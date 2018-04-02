package xyz.deseteral.phobot.modules;

import org.springframework.stereotype.Component;
import xyz.deseteral.phobot.invocation.model.Response;

@Component
public class PingModule {
    public Response getPong() {
        return new Response("pong");
    }
}
