import java.util.ArrayList;

public class Driver {
    private static final int WRITERS = 1000;
    private static final int REQUESTS = 10000;
    public static void main(String[] args) {
        ArrayList<GenericActor> writers = new ArrayList<>();
        for (int i = 0;i<WRITERS;i++){
            writers.add(new WriterActor());
        }
        for (int i = 0;i<REQUESTS;i++){
            writers.get(i % WRITERS).tell("Hello: " + i);
        }
        for (int i = 0;i<WRITERS;i++){
            writers.get(i).poisonPill();
        }
    }
}
