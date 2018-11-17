package thread.blockingqueue;

import java.util.concurrent.BlockingDeque;

public class Producer implements Runnable {

    private BlockingDeque<Integer> queue;
    private int domain;

    Producer(BlockingDeque<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                int random = (int) (Math.random() * domain);
                queue.put(random);
                System.out.println("生成随机数" + random);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
