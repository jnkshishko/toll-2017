package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan({"hello","controllers","services"})
@EnableJpaRepositories("dao")
@EntityScan(basePackageClasses = jnksh.PointDTO.class)

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
        @Bean
        public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
        }


}
