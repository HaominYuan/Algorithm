package thread.blockingqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable {
    private BlockingDeque<Integer> queue;
    private int domain = 1000;
    private boolean[] array;

    public Consumer(BlockingDeque<Integer> queue) {
        this.queue = queue;

        array = new boolean[domain + 1];
        array[0] = true;
        array[1] = true;
        for (int i = 2; i < array.length; i++) {
            if (!array[i]) {
                int j = 2;
                while (j * i <= domain) {
                    array[j * i] = true;
                    j = j + 1;
                }
            }
        }
    }


    private String isPrimer(int number) {
        if (array[number]) {
            return number + "不是质数。";
        }
        return number + "是质数";
    }


    @Override
    public void run() {
        Integer number;
        try {
            while ((number = queue.poll(1, TimeUnit.SECONDS)) != null) {
                System.out.println(isPrimer(number));
            }
        } catch (Exception ignore) {}
    }
}
