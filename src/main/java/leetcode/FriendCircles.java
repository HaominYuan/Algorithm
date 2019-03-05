package leetcode;

public class FriendCircles {
    public static void main(String[] args) {
//        [1,0,0,1],
//        [0,1,1,0],
//        [0,1,1,1],
//        [1,0,1,1]


        int[][] graph = new int[4][];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new int[4];
        }
        graph[0][0] = 1;graph[0][1] = 0;graph[0][2] = 0;graph[0][3] = 1;
        graph[1][0] = 1;graph[1][1] = 1;graph[1][2] = 1;graph[1][3] = 0;
        graph[2][0] = 1;graph[2][1] = 1;graph[2][2] = 1;graph[2][3] = 1;
        graph[3][0] = 1;graph[3][1] = 0;graph[3][2] = 1;graph[3][3] = 1;

        System.out.println(new Solution().findCircleNum(graph));
    }

    static class Solution {
        public int findCircleNum(int[][] M) {
            int[] father = new int[M.length];
            int[] rank = new int[M.length];
            for (int i = 0; i < father.length; i++) {
                father[i] = i;
                rank[i] = 0;
            }

            for (int i = 0; i < M.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (M[i][j] == 1) {
                        int fatherI = find(father, i);
                        int fatherJ = find(father, j);
                        if (fatherI != fatherJ) {
                            if (rank[fatherI] < rank[fatherJ]) {
                                father[fatherJ] = fatherI;
                                rank[fatherJ] = Math.max(rank[fatherJ], rank[fatherI] + 1);
                            } else {
                                father[fatherI] = fatherJ;
                                rank[fatherJ] = Math.max(rank[fatherI], rank[fatherJ] + 1);
                            }
                        }
                    }
                }
            }

            int sum = 0;
            for (int i = 0; i < father.length; i++) {
                if (father[i] == i) {
                    sum = sum + 1;
                }
            }
            return sum;
        }

        int find(int[] father, int x) {
            if (x == father[x]) {
                return x;
            }
            return find(father, father[x]);
        }
    }

}
