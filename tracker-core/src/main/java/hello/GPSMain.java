package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class GPSMain {

    public static void main(String... args){

        SpringApplication app = new SpringApplication(GPSContext.class);
        app.setWebEnvironment(false);
        ConfigurableApplicationContext context = app.run(args);
    }

}
