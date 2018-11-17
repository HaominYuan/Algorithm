package thread.randomprimenumber;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        func1();
    }


    static void func1() {
        Number number = new Number(1);
        Generator generator = new Generator(number);
        Discriminator discriminator = new Discriminator(number);
        generator.start();
//        thread.sleep(1000);
        discriminator.start();
    }
}
