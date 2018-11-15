package connectivity;

public class Test {
    public static void main(String[] args) {
        Graph graph = new Graph("src/connectivity/test1");
        System.out.println(new BruteForce(graph).calBridge());
        System.out.println(new UnionFindBase(graph).calBridge());
    }
}
