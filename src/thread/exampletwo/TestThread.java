package thread.exampletwo;

public class TestThread extends Thread {
    public TestThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
//            for (long k = 0; k < 100000000; k++) ;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + ":" + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new TestThread("李白");
//        thread t2 = new TestThread("屈原");
        t1.start();
        t1.join();
//        t2.start();
        System.out.println(currentThread().getName());
    }


}
