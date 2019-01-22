public class Main {

    public static void main(String[] args) {
        System.out.println(func());
    }

    private static int func() {
        int x = 0;
        try {
            x = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("进来了吗3");
            x = 2;
            System.out.println("进来了吗2");
            return x;
        } finally {
            x = 3;
            System.out.println("进来了吗1");
        }
    }
}