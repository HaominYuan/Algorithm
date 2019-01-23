package maximumflowinaflownetwork;

import java.util.*;
public class Main {
    private static int edmondsKarp(boolean[][] E, int[][] capacity, int source, int sink) {
        int vertex = capacity.length;
        int[][] flow = new int[vertex][vertex];
        int[] parent = new int[vertex];
        while (true) {
            // 将所有节点的父亲赋值为-1
            Arrays.fill(parent, -1);
            // 将开始节点的父亲赋值为其本身
            parent[source] = source;
            // 用来记录每个节点的流量
            int[] M = new int[vertex];
            // 每个节点的流量设置为最大
            M[source] = Integer.MAX_VALUE;
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(source);
            LOOP:
            while (!Q.isEmpty()) {
                int u = Q.poll();
                for (int v = 0; v < E[u].length; v++) {
                    // 如果存在路径
                    if (E[u][v]) {
                        // 如果有剩余流量，并且没有被访问过
                        if (capacity[u][v] - flow[u][v] > 0 && parent[v] == -1) {
                            // 将新节点的父亲指向旧节点
                            parent[v] = u;
                            // 比较当前流量
                            M[v] = Math.min(M[u], capacity[u][v] - flow[u][v]);
                            // 如果不是根节点则继续遍历
                            if (v != sink)
                                Q.offer(v);
                            else {
                                // 输出路径，更新矩阵
                                Stack<Integer> stack = new Stack<>();
                                while (parent[v] != v) {
                                    u = parent[v];
                                    stack.add(u + 1);
                                    flow[u][v] += M[sink];
                                    flow[v][u] -= M[sink];
                                    v = u;
                                }
//                                System.out.display("流量：" + M[sink] + "，路径：");
//                                while (!stack.isEmpty()) {
//                                    System.out.display(stack.pop() + "--");
//                                }
//                                System.out.println(sink + 1);
                                break LOOP;
                            }
                        }
                    }
                }
            }
            // 如果sink节点的父亲节点为-1，意味着没有找到路径
            if (parent[sink] == -1) {
                int sum = 0;
                for (int x : flow[source])
                    sum += x;
                return sum;
            }
        }
    }


    public static void main(String[] args) {
        myTest();
    }

    void hduTest() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int edge = scanner.nextInt();
            int vertex = scanner.nextInt();
            boolean[][] E = new boolean[vertex][vertex];
            int[][] C = new int[vertex][vertex];
            for (int i = 0; i < edge; i++) {
                int point1 = scanner.nextInt();
                int point2 = scanner.nextInt();
                int capacity = scanner.nextInt();
                E[point1-1][point2-1] = true;
                E[point2-1][point1-1] = true;
                C[point1 - 1][point2 - 1] = C[point1 - 1][point2 - 1] + capacity;
            }
            System.out.println("总流量：" + edmondsKarp(E, C, 0, vertex - 1));
        }
    }

    private static void myTest() {
        // 这个是测试点的算法，假设边的个数为500个，点的个数从50到100（步长为10）。
        // 测试的数据是从100到1000，
        for (int i = 1; i <= 10; i++) {
            double sum = 0;
            for (int j = 0; j < 100; j++) {
                Graph graph = new Graph(i * 100, (i * 100) * (i * 100 - 1) * 3 / 8);
                double begin = System.currentTimeMillis();
                edmondsKarp(graph.getE(), graph.getC(), 0, graph.getVertexNumber() - 1);
                double end = System.currentTimeMillis();
                sum = end - begin;
            }
            System.out.println(i * 100 + "个点的30次的平均时间为：" + sum / 30);
        }
    }

}