public class PrintAlpha implements Runnable{
    private char alpha = 'A';
    private final Object object;

    PrintAlpha(Object object) {
        this.object = object;
    }


    @Override
    public void run() {
        synchronized (object) {
            for (int i = 0; i < 26; i++) {
                System.out.println(alpha++);

                object.notify();
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
