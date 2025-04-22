package com.example.securityDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/posts/1", Object.class);
        System.out.println(response.getBody());*/

        /*WebClient webClient = WebClient.create();
        Mono<String> response = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve().
                bodyToMono(String.class);

        response.subscribe(System.out::println);*/
    }

}
