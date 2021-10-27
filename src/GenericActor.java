import java.util.concurrent.LinkedBlockingQueue;

public abstract class GenericActor {
    private final LinkedBlockingQueue<Object> mailbox = new LinkedBlockingQueue<>();
}
