package xyz.deseteral.phobot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adapter/telegram")
public class TelegramController {
    private TelegramClient client;

    @Autowired
    public TelegramController(TelegramClient client) {
        this.client = client;
    }

    @PostMapping
    void postUpdate(@RequestBody Update update) {
        final String text = update.getMessage().getText().equals("ping")
                ? "pong"
                : "what?";

        OutgoingMessage outgoingMessage = new OutgoingMessage(
                update.getMessage().getChat().getId(),
                text
        );

        client.sendMessage(outgoingMessage);
    }
}
