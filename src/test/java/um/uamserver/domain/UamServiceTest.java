package um.uamserver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.DefaultUriBuilderFactory;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class UamServiceTest {

    private static final String ARRIVAL_API = "34.64.73.86:8080/completeFlight";
    private static final String TEMP_API = "http://localhost:8081/api/test";

    @Test
    @DisplayName("")
    void test() {
        WebClient webClient = WebClient.create();
        webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path(TEMP_API)
                        .build())
                .exchangeToMono(response -> {
                    log.info("{}", response.statusCode());
                    return response.bodyToMono(Void.class);
                }).block();
        log.info("진짜 끝");
    }

    @Test
    @DisplayName("잘된다.")
    void test1() {
        WebClient webClient = WebClient.create();
        RequestDto requestDto = new RequestDto("ABC");
        webClient.method(HttpMethod.POST)
                .uri(TEMP_API)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(requestDto)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    static class RequestDto {
        String uamIdentification;
    }


}