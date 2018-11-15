public class PrintNumber implements Runnable {
    private int count = 0;
    private Object object;

    PrintNumber(Object object) {
        this.object = object;
    }


    @Override
    public void run() {
        for (int i = 1; i <= 52; i++) {
            System.out.println(i);
            count = count + 1;
            if (count % 2 == 0) {
                object.notify();
            }
            try {
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
