

import jnksh.services.DataPeekService;
import jnksh.services.DataSendService;
import jnksh.services.GPSService;
import jnksh.services.GPSToolService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GPSContext {

    @Bean
    public DataPeekService peekService() {
        return new DataPeekService();
    }

    @Bean
    public DataSendService sendService() {
        return new DataSendService();
    }

    @Bean
    public GPSToolService gpsToolService() {
        return new GPSToolService();
    }

    @Bean
    public GPSService gpsService() {
        return new GPSService();
    }

}
