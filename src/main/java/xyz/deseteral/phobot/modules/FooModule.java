package xyz.deseteral.phobot.modules;

import xyz.deseteral.phobot.invocation.InvocationProcessor;
import xyz.deseteral.phobot.invocation.model.Invocation;
import xyz.deseteral.phobot.invocation.model.Response;

public class FooModule implements InvocationProcessor {
    @Override
    public Response process(Invocation invocation) {
        return new Response("bar");
    }

    @Override
    public boolean doesInvocationQualify(Invocation invocation) {
        return invocation.getText().equals("foo");
    }
}
