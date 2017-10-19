package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

public class GPSMain {

    public static void main(String... args){

//        ApplicationContext context = new AnnotationConfigApplicationContext(GPSContext.class);
//        ApplicationContext context = SpringApplication.run(GPSContext.class, args);
        SpringApplication app = new SpringApplication(GPSContext.class);
        app.setWebEnvironment(false);
        ConfigurableApplicationContext ctx = app.run(args);
    }

}
