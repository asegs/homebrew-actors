public class WriterActor extends GenericActor{
    @Override
    protected void receive(Object message) {
        String str = (String) message;
        System.out.println(str);
    }
}
