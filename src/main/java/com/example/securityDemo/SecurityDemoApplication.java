package com.example.securityDemo;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StreamUtils;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.securityDemo", "com.example.messageModule"})
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
        /*RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object> response = restTemplate
                .getForEntity("https://jsonplaceholder.typicode.com/posts/1", Object.class);
        System.out.println(response.getBody());

        WebClient webClient = WebClient.create();
        Flux<String> monoResponse = webClient.get()
                .uri("https://jsonplaceholder.typicode.com/posts/1")
                .retrieve().
                bodyToFlux(String.class);

        monoResponse.subscribe(System.out::println);*/
//        WebClient webClient = WebClient.create();
        /*webClient.get()
                .uri("https://stream.wikimedia.org/v2/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(System.out::println);*/
        /*webClient.get()
                .uri("https://stream.wikimedia.org/v2/stream/recentchange")
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);*/
    }

    @Bean
    public ApplicationRunner runOnStartup(JdbcTemplate jdbcTemplate) {
        return args -> {
            ClassPathResource classPathResource = new ClassPathResource("createAdmin.sql");
            if (!classPathResource.exists()) {
                throw new IllegalStateException("SQL file not found: " + classPathResource.getFilename());
            }

            String sql = StreamUtils.copyToString(
                classPathResource.getInputStream(),
                StandardCharsets.UTF_8);

            for (String statement: sql.split(";")) {
                statement = statement.trim();
                if (!statement.isEmpty()) {
                    jdbcTemplate.execute(statement);
                }
            }
        };
    }

}
