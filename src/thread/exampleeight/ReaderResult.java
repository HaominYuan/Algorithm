package thread.exampleeight;

public class ReaderResult extends Thread {
    Calculator calculator;

    public ReaderResult(Calculator calculator) {

        this.calculator = calculator;
    }

    public void run() {
        synchronized (calculator) {
            try {
                System.out.println(Thread.currentThread() + "等待计算结果.....");
                calculator.wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + "计算结果为：" + calculator.total);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        new ReaderResult(calculator).start();
        calculator.start();
    }
}
