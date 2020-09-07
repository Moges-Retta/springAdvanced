package be.vdab.atbean.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeansConfiguration {
    @Bean
    DefaultKwadraatService kwadraat() {
        return new DefaultKwadraatService();
    }
}
