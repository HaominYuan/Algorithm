package Thread.examplesix;

public class Deadlock extends Thread {
    private static class Resource {
        public int value;
    }

    private Resource resourceA = new Resource();
    private Resource resourceB = new Resource();

    public int read() throws InterruptedException {
        synchronized (resourceA) {
            Thread.sleep(1000);

            synchronized (resourceB) {
                return resourceB.value + resourceA.value;
            }
        }
    }

    public void write(int a, int b) throws InterruptedException {
        synchronized (resourceB) {
            Thread.sleep(1000);
            synchronized (resourceA) {
                resourceA.value = a;
                resourceB.value = b;
            }
        }
    }

    @Override
    public void run() {
        try {
            read();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Deadlock deadlock = new Deadlock();
        deadlock.start();
        deadlock.write(1, 2);
    }
}
