package thread.randomprimenumber;

public class Discriminator extends Thread {

    private final Number number;
    private int domain = 1000;
    private boolean[] array;

    public void setDomain(int domain) {
        this.domain = domain;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            synchronized (number) {
                if (!number.isFlag()) {
                    try {
                        number.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(isPrimer(number.getNumber()));
                number.setFlag(false);
                number.notify();
            }
        }
    }

    private String isPrimer(int number) {
        if (array[number]) {
            return number + "不是质数。";
        } else {
            return number + "是质数。";
        }
    }


    Discriminator(Number number) {
        this.number = number;
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
}
