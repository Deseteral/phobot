package xyz.deseteral.phobot.telegram;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import xyz.deseteral.phobot.telegram.model.OutgoingMessage;

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
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<OutgoingMessage> entity = new HttpEntity<>(message, headers);

        restTemplate.exchange(
                url("/sendMessage"),
                HttpMethod.POST,
                entity,
                Void.class
        );
    }

    private String url(String path) {
        return "https://api.telegram.org/bot" + token + path;
    }
}
