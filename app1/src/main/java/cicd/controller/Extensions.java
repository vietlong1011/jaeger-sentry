// package cicd.controller;

// import cicd.Student;
// import cicd.User;
// import cicd.repository.UserRepository;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.PathVariable;

// import io.opentracing.Scope;
// import io.opentracing.Span;
// import io.opentracing.Tracer;

// import java.util.ArrayList;
// import java.util.List;

// import io.sentry.Sentry;

// @RestController
// public class Extensions {

//     @Autowired
//     private Tracer tracer ;

     
//     @GetMapping("/formatGreeting/{name}")
//     public String formatGreeting(@PathVariable String name) {
//         try (Scope scope = tracer.buildSpan("format-greeting").startActive(true)) {
//             Span span = scope.span();
//             span.log("formatting message remotely for name " + name);
//             String response = "Hello, from app 1 " + name + "!";
//             String myBaggage = span.getBaggageItem("my-baggage");
//             span.log("this is baggage " + myBaggage);
//             return response;
//         }
//     }

//     @GetMapping("/sentry")
//     public String testException() {
//         try {
//             // Ném ngoại lệ giả lập
//             throw new Exception("Spring Boot Test Exception");
//         } catch (Exception e) {
//             // Ghi nhận ngoại lệ trong Sentry
//             Sentry.captureException(e);
//             return "Exception captured and sent to Sentry!";
//         }
//     }
    
//     @GetMapping("/oups")
//     public String triggerException(){
//         throw new RuntimeException(
//             "Error exception"
//         );
//     }
// }
