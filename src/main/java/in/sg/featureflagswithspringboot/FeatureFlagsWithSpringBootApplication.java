package in.sg.featureflagswithspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class FeatureFlagsWithSpringBootApplication {

  public static void main(String[] args) {
    SpringApplication.run(FeatureFlagsWithSpringBootApplication.class, args);
  }
}
