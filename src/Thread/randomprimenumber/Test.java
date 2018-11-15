package Thread.randomprimenumber;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        func1();
    }


    static void func1() {
        Number number = new Number(1);
        Generator generator = new Generator(number);
        Discriminator discriminator = new Discriminator(number);
        generator.start();
//        Thread.sleep(1000);
        discriminator.start();
    }
}
