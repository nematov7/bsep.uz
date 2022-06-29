package uz.bsep.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {
    @Bean
    ObjectMapper getObjectMapper(){
        return new ObjectMapper();
    }
}
