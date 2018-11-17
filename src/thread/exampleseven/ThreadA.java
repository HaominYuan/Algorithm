package thread.exampleseven;

public class ThreadA {
    public static void main(String[] args) throws InterruptedException {
        ThreadB b = new ThreadB();
        b.start();
        synchronized (b) {
            System.out.println("等待对象b完成计算......");
            b.wait();
            System.out.println("b对象计算的总和是：" + b.total);
        }

    }

}
