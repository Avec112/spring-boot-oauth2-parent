package io.avec.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.clientRegistrationId;

@Slf4j
@SpringBootApplication
public class ClientApplication implements CommandLineRunner {

    @Autowired
    private WebClient webClient;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        String url = "http://localhost:8092/hello";
        String result = this.webClient
                .get()
                .uri(url)
                .attributes(clientRegistrationId("myClientRegistrationId"))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        log.debug("{} -> {}", url, result);
    }
}
