package com.example.clientproject;

import com.example.clientproject.models.Place;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ClientprojectApplication {

    private static final Logger log = LoggerFactory.getLogger(ClientprojectApplication.class);//org.slf4j.Logger

    public static void main(String[] args) {
        SpringApplication.run(ClientprojectApplication.class, args);
    }
    @Bean
    public CommandLineRunner run(){
        return args -> {
            RestTemplate restTemplate = new RestTemplate();
//            Quote quote = restTemplate.getForObject("https://gturnquist-quoters.cfapps.io/api/random",Quote.class);
//            log.info(quote.toString());

            Map<String,Long> params = new HashMap<>();
            params.put("id",5l);
            Place place = restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts",Place.class,params);
            log.info(place.toString());
        };
    }


}
