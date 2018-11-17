package thread.exampleone;

public class TestRunnable {
    public static void main(String[] args) {
        RunnableImpl ri1 = new RunnableImpl("李白");
        RunnableImpl ri2 = new RunnableImpl("屈原");
        Thread t1 = new Thread(ri1);
        Thread t2 = new Thread(ri2);
        t1.start();
        t2.start();
    }

}
