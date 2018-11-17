package thread.examplefour;

public class FooRunnable implements Runnable {
    private Foo foo = new Foo();

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            synchronized (this) {
                this.fix(30);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " :当前foo对象的x值=" + foo.getX());
            }
            Thread.yield();
        }
    }


    public static void main(String[] args) {
        FooRunnable r = new FooRunnable();
        Thread ta = new Thread(r, "thread-A");
        Thread tb = new Thread(r, "thread-B");
        ta.start();
        tb.start();
    }

    public int fix(int y) {
        return foo.fix(y);
    }
}
