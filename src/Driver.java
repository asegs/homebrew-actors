public class Driver {
    public static void main(String[] args) {
        GenericActor writer = new WriterActor();
        for (int i = 0;i<100;i++){
            writer.tell("Hello: " + i);
        }
        writer.poisonPill();
    }
}
