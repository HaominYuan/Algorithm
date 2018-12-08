package maximumflowinaflownetwork;

import java.util.*;

/*
 * Finds the maximum flow in a flow network.
 * @param E neighbour lists
 * @param C capacity matrix (must be n by n)
 * @param s source
 * @param t sink
 * @return maximum flow
 */
public class EdmondsKarp {
    public static int edmondsKarp(int[][] E, int[][] C, int s, int t) {
        int n = C.length;
        // Residual capacity from u to v is C[u][v] - F[u][v]
        int[][] F = new int[n][n];
        while (true) {
            int[] parent = new int[n]; // Parent table
            Arrays.fill(parent, -1);
            parent[s] = s;
            int[] M = new int[n]; // Capacity of path to node
            M[s] = Integer.MAX_VALUE;
            // BFS queue
            Queue<Integer> Q = new LinkedList<>();
            Q.offer(s);
            LOOP:
            while (!Q.isEmpty()) {
                int u = Q.poll();
                for (int v : E[u]) {
                    // There is available capacity,
                    // and v is not seen before in search
                    if (C[u][v] - F[u][v] > 0 && parent[v] == -1) {
                        parent[v] = u;
                        M[v] = Math.min(M[u], C[u][v] - F[u][v]);
                        if (v != t)
                            Q.offer(v);
                        else {
                            // Backtrack search, and write flow
                            while (parent[v] != v) {
                                u = parent[v];
                                F[u][v] += M[t];
                                F[v][u] -= M[t];
                                v = u;
                            }
                            break LOOP;
                        }
                    }
                }
            }
            if (parent[t] == -1) { // We did not find a path to t
                int sum = 0;
                for (int x : F[s])
                    sum += x;
                return sum;
            }
        }
    }


    public static void main(String[] args) {
        int[][] edge = new int[6][];
        edge[0] = new int[]{1, 3};
        edge[1] = new int[]{2, 4};
        edge[2] = new int[]{5};
        edge[3] = new int[]{2, 4};
        edge[4] = new int[]{5};
        edge[5] = new int[]{};
        int[][] c = new int[6][6];
        c[0][1] = 6;
        c[0][3] = 7;
        c[1][2] = 4;
        c[1][4] = 4;
        c[2][5] = 4;
        c[3][2] = 3;
        c[3][4] = 2;
        c[4][5] = 8;
        System.out.println(edmondsKarp(edge, c, 0, 5));
    }
}