package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;

public class GPSMain {

    public static void main(String... args){

//        ApplicationContext context = new AnnotationConfigApplicationContext(GPSContext.class);
        ApplicationContext context = SpringApplication.run(GPSContext.class, args);
    }

}
