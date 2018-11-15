package closepointpair;
public class Test {
    private static int N = 10000;
    private static int m = 40;
    public static void main(String[] args) {
//        System.out.println(1 / 2. * Math.pow(N, 2) / (N * (Math.log(N) / Math.log(2))));
        for (int k = 1; k <= 10; k++) {
            double sum1 = 0;
            double sum2 = 0;
            for (int j = 0; j < m; j++) {
                Double[][] points1 = Utils.generalNPoint(k * N);
                Point2D[] point2DS = new Point2D[k * N];
                for (int i = 0; i < points1.length; i++) {
                    point2DS[i] = new Point2D(points1[i][0], points1[i][1]);
                }
                double temp;
                double begin = System.nanoTime();
                temp = BruteForce.func(points1);
                double stop1 = System.nanoTime();
                ClosestPair closestPair = new ClosestPair(point2DS);
                double stop2 = System.nanoTime();
                sum1 = sum1 + stop1 - begin;
                sum2 = sum2 + stop2 - stop1;
            }
            System.out.println("规模为：" + k * N + " 蛮力法：" + sum1 / m);
            System.out.println("规模为：" + k * N + " 分治法：" + sum2 / m);
            System.out.println();
        }
    }
}
