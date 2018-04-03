package xyz.deseteral.phobot.invocation;

import xyz.deseteral.phobot.invocation.model.Invocation;
import xyz.deseteral.phobot.invocation.model.Response;

public interface InvocationProcessor {
    Response process(Invocation invocation);
    boolean doesInvocationQualify(Invocation invocation);
}
