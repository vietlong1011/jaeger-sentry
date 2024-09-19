package cicd.controller;

import java.net.URI;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;

// hostname
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class JaegerController {
    
    static int counter = 1;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Tracer tracer;

    @GetMapping("/sayHello/{name}")
    public String sayHello(@PathVariable String name) {
        try (Scope scope = tracer.buildSpan("say-hello-handler").startActive(true)) {
            Span span = scope.span();
            Map<String, String> fields = new LinkedHashMap<>();
            fields.put("event", name);
            fields.put("message", "this is a log message for name " + name);
            span.log(fields);
            // you can also log a string instead of a map, key=event value=<stringvalue>
            // span.log("this is a log message for name " + name);
            span.setBaggageItem("my-baggage", name);
            String response = formatGreetingRemote(name);
            span.setTag("response", response);
            return response;
        }
    }

    private String formatGreeting(String name) {
        try (Scope scope = tracer.buildSpan("format-greeting").startActive(true)) {
            Span span = scope.span();
            span.log("formatting message locally for name " + name);
            String response = "Hello " + name + "!";
            return response;
        }
    }

    private String formatGreetingRemote(String name) {

        String serviceName = System.getenv("SERVICE_NAME");
        String portName = System.getenv("SERVICE_PORT");
        String apiName = System.getenv("SERVICE_API");

        if (serviceName == null ) {
            // try{
            // InetAddress inetAddress = InetAddress.getLocalHost();
            // String hostName = inetAddress.getHostName();
            // serviceName = hostName ;
            // } catch (UnknownHostException e) {
            //     e.printStackTrace();
            // }
            serviceName = "172.21.21.12";
        }
        
        if (portName == null ){
            portName = "31186";
        } 
        if (apiName == null){
            apiName = "formatGreeting";
        }
    
        //hard code

        // String serviceName = "localhost" ;
        // String portName = "8086";
        // String apiName = "formatGreeting";

        String urlPath = "http://" + serviceName + ":" + portName + "/"+ apiName + "/" + name ;
        System.out.println("url : " + urlPath );
        URI uri = UriComponentsBuilder //
                .fromHttpUrl(urlPath) //
                .queryParam("name", name).build(Collections.emptyMap());
        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        return response.getBody();

    }


    @GetMapping("/error")
    public ResponseEntity<String> replyError() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

}
