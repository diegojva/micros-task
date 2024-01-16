package com.nttdata.escuela.libro.configuration;

import com.nttdata.escuela.libro.apimodel.StrategyBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BookConfiguration {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public StrategyBean strategyBean() {
        return new StrategyBean();
    }
}
