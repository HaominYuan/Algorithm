package thread.exampleseven;

public class ThreadB extends Thread {
    int total;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 101; i++) {
                total = total + 1;
            }
        }
        notify();
    }
}
