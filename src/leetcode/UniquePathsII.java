package leetcode;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] map = new int[3][];
        for (int i = 0; i < map.length; i++) {
            map[i] = new int[3];
        }
        map[1][1] = 1;
        System.out.println(new Solution().uniquePathsWithObstacles(map));
    }

    static class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {

            if (obstacleGrid[0][0] == 1 || obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] == 1) {
                return 0;
            }

            obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1] = -1;


            for (int i = obstacleGrid.length - 1; i >= 0; i--) {
                for (int j = obstacleGrid[i].length - 1; j >= 0; j--) {
                    if (obstacleGrid[i][j] == 1) {
                        continue;
                    }
                    if (i + 1 < obstacleGrid.length && obstacleGrid[i + 1][j] < 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i + 1][j];
                    }
                    if (j + 1 < obstacleGrid[i].length && obstacleGrid[i][j + 1] < 0) {
                        obstacleGrid[i][j] = obstacleGrid[i][j] + obstacleGrid[i][j + 1];
                    }
                }
            }


            return -obstacleGrid[0][0];
        }
    }
}
