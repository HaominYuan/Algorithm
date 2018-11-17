package thread.exampleeight;

public class Calculator extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            notifyAll();
            for (int i = 0; i < 101; i++) {
                total = total + 1;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
