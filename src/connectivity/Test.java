package connectivity;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph("src/connectivity/test3");
        BruteForce bruteForce = new BruteForce(graph);
        bruteForce.calBridge();
//        System.out.println(bruteForce);
//        UnionFindBase unionFindBase = new UnionFindBase(graph);
//        unionFindBase.calBridge();
//        System.out.println(unionFindBase);
//        int x = 100;
//        for (int i = 0; i < 4; i++) {
//            helper(x, x, 1000);
//            x = x * 10;
//            System.out.println("------------");
//        }
    }


    private static void helper(int verticeNumber, int edgeNumber, int time) {
        double sum1 = 0, sum2 = 0;
        for (int i = 0; i < time; i++) {
            Graph graph = new Graph(verticeNumber, edgeNumber);
            sum1 = sum1 + CalTime.calTime(new BruteForce(graph));
            sum2 = sum2 + CalTime.calTime(new UnionFindBase(graph));
        }
        System.out.println(sum1 / time);
        System.out.println(sum2 / time);
    }

}
