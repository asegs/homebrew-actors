public class Driver {
    public static void main(String[] args) {
        GenericActor writer = new WriterActor();
        writer.tell("Hello");
    }
}
