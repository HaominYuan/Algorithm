public class Test {
    public static void main(String[] args) {
        Object object = new Object();
        new Thread(new PrintNumber(object)).start();
        new Thread(new PrintAlpha(object)).start();
    }
}
