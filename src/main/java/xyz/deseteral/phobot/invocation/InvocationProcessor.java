package xyz.deseteral.phobot.invocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.deseteral.phobot.invocation.model.Invocation;
import xyz.deseteral.phobot.invocation.model.Response;
import xyz.deseteral.phobot.modules.PingModule;

@Component
public class InvocationProcessor {
    private final PingModule pingModule;

    private final Response DEFAULT_RESPONSE = new Response(
            "I don't know anything about that."
    );

    @Autowired
    public InvocationProcessor(PingModule pingModule) {
        this.pingModule = pingModule;
    }

    public Response process(Invocation invocation) {
        if (invocation.getText().equals("ping")) {
            return pingModule.getPong();
        }

        return DEFAULT_RESPONSE;
    }
}
