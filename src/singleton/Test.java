package singleton;

import java.util.concurrent.CountDownLatch;

public class Test {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int threadNum = 10;

        CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < threadNum; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 100000; i1++) {
                    Object o = SingletonDemo05.SINGLETON_DEMO_05;
                }
            }).start();
        }

        long end = System.currentTimeMillis();
        System.out.println("总耗时:" + (end - start));
    }
}
