package thread.randomprimenumber;

public class Generator extends Thread {

    private final Number number;
    private int domain = 1000;


    public void setDomain(int domain) {
        this.domain = domain;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (number) {
                if (number.isFlag()) {
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                number.setNumber((int) (Math.random() * domain));
                number.setFlag(true);
                System.out.println("生成随机数" + number.getNumber());
                number.notify();
            }
        }

    }

    Generator(Number number) {
        this.number = number;
    }
}
