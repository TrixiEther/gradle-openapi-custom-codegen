package dev.trixiether.sample;

    import com.fasterxml.jackson.databind.Module;
    import org.openapitools.jackson.nullable.JsonNullableModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.FullyQualifiedAnnotationBeanNameGenerator;

@SpringBootApplication(
nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
@ComponentScan(
basePackages = {"dev.trixiether.sample", "dev.trixiether.sample.entry" , "dev.trixiether.sample.configuration"},
nameGenerator = FullyQualifiedAnnotationBeanNameGenerator.class
)
public class SampleApplication {

public static void main(String[] args) {
SpringApplication.run(SampleApplication.class, args);
}

    @Bean(name = "dev.trixiether.sample.SampleApplication.jsonNullableModule")
    public Module jsonNullableModule() {
    return new JsonNullableModule();
    }

}
