package com.example.securityDemo;

import com.example.securityDemo.readModel.document.UserRead;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.securityDemo", "com.example.messageModule"})
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
/*        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/posts/1", Object.class);
        System.out.println(response.getBody());

        WebClient webClient = WebClient.create();
        Flux<String> monoResponse = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve().
                bodyToFlux(String.class);

        monoResponse.subscribe(System.out::println);*/

        /*WebClient webClient = WebClient.create();
        webClient.get()
                .uri("https://stream.wikimedia.org/v2/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(System.out::println);*/
    }

}
