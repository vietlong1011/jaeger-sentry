package cicd;

import java.sql.Connection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.jaegertracing.Configuration.ReporterConfiguration;
import io.jaegertracing.Configuration.SamplerConfiguration;

import io.sentry.Sentry;
import io.sentry.SentryOptions;

@SpringBootApplication
public class App1Application {

	@Bean
	public io.opentracing.Tracer initTracer() {
		SamplerConfiguration samplerConfig = new SamplerConfiguration().withType("const").withParam(1);
		ReporterConfiguration reporterConfig = ReporterConfiguration.fromEnv().withLogSpans(true);
		return Configuration.fromEnv("app1").withSampler(samplerConfig).withReporter(reporterConfig).getTracer();
	}

	public static void main(String[] args) {

		SentryOptions options = new SentryOptions();
        options.setDsn("http://ea4f89d98446a50e221f8d0b25b500ea@172.21.21.10:9000/5");
        options.setEnvironment("production");

        // Khởi tạo Sentry với cấu hình đã được thiết lập
        Sentry.init(options);

		// ham try mac dinh tra ve 2 error -> sentry
        try {
			SpringApplication.run(App1Application.class, args);
			System.out.println("Test App1");
            throw new Exception("This is a test sentry.");
        } catch (Exception e) {
            Sentry.captureMessage("Sentry has been successfully configured!");
            Sentry.captureException(e);
            System.out.println("Exception thrown for Sentry");
        }
	}

}