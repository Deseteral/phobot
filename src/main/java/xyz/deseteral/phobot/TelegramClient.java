package xyz.deseteral.phobot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TelegramClient {
    private RestTemplate restTemplate;
    private String token;

    public TelegramClient(
            @Value("TELEGRAM_TOKEN") String token
    ) {
        this.restTemplate = new RestTemplate();
        this.token = token;
    }

    public void sendMessage(OutgoingMessage message) {
        restTemplate.postForObject(
                url("/sendMessage"),
                message,
                Void.class
        );
    }

    private String url(String path) {
        return "https://api.telegram.org/bot" + token + path;
    }
}
