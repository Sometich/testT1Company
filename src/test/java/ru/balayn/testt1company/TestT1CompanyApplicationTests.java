package ru.balayn.testt1company;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestT1CompanyApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("Проверка status code = 200 при успешной обработке")
    void chechStatusCodeWhenSuccess() {
        String url = "http://localhost:" + port + "/frequency?input=AaaLLLLoopfg";

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).isNotNull();
    }

    @Test
    @DisplayName("Проверка, что при пустом переданном параметре, возвращается пустой массив")
    void chechStatusValidAnswear() {
        String url = "http://localhost:" + port + "/frequency?input=";

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().toString()).isEqualTo("{}");
    }

    @Test
    @DisplayName("Проверка что счетчик корректно считает и сортирует ответ")
    void chechStatusValidAnswearWhenEmptyInput() {
        String url = "http://localhost:" + port + "/frequency?input=aaLLLLaf";
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat(response.getBody().toString()).isEqualTo("{L=4, a=3, f=1}");
    }

}
