package xyz.deseteral.phobot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TelegramClient {
    private RestTemplate restTemplate;
    private String token;

    public TelegramClient(
            @Value("${TELEGRAM_TOKEN}") String token
    ) {
        this.restTemplate = new RestTemplate();
        this.token = token;
    }

    public void sendMessage(OutgoingMessage message) {
        System.out.println();
        System.out.println(url("/sendMessage"));
        System.out.println();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OutgoingMessage> entity = new HttpEntity<>(message, headers);


        ResponseEntity<TelegramResponse> response = restTemplate.exchange(
                url("/sendMessage"),
                HttpMethod.POST,
                entity,
                TelegramResponse.class
        );

        System.out.println("xxxxxx");
        System.out.println(response.getBody().getDescription());
        System.out.println();

//        ResponseEntity<String> response = restTemplate.postForObject(
//                url("/sendMessage"),
//                entity,
//                String.class
//        );
    }

    private String url(String path) {
        return "https://api.telegram.org/bot" + token + path;
    }
}
