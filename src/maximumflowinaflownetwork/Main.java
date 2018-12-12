package maximumflowinaflownetwork;

import java.util.*;
public class Main {
    private int edmondsKarp(boolean[][] E, int[][] capacity, int source, int sink) {
        int vertex = capacity.length;
        int[][] flow = new int[vertex][vertex];
        int[] parent = new int[vertex];
        while (true) {
            Arrays.fill(parent, -1);
            parent[source] = source;
            int[] M = new int[vertex];
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
                                while (parent[v] != v) {
                                    u = parent[v];
                                    flow[u][v] += M[sink];
                                    flow[v][u] -= M[sink];
                                    v = u;
                                }
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
            System.out.println(new Main().edmondsKarp(E, C, 0, vertex - 1));
        }
    }
}