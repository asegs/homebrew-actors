import static java.lang.Thread.sleep;

public class WriterActor extends GenericActor{

    private void safeSleep(int n){
        try {
            sleep(n);
        }catch (Exception e){
            ;
        }
    }
    @Override
    protected void receive(Object message) {
        safeSleep(100);
        String str = (String) message;
        System.out.println(str);
    }

    @Override
    protected void die() {
        System.out.println("Killed.");
    }
}
