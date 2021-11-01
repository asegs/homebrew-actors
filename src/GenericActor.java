import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public abstract class GenericActor {
    private final long afterlifeDuration = 100;
    private final LinkedBlockingQueue<Object> mailbox = new LinkedBlockingQueue<>();
    private boolean killed = false;

    public GenericActor(){
        new Thread(this::handler).start();
    }

    //why is java so ornery about this, i don't want this to be callable by driver
    protected abstract void receive(Object message);
    protected void die(){}
    protected void birth(){}


    private void handler(){
        birth();
        while (!killed || mailbox.size() > 0){
            try {
                Object o = mailbox.poll(afterlifeDuration,TimeUnit.MILLISECONDS);
                if (o != null){
                    receive(o);
                }
            }catch (InterruptedException e){
                killed = true;
            }
        }
        die();
    }

    public void poisonPill(){
        killed = true;
    }

    public void tell(Object message){
        mailbox.add(message);
    }
}
