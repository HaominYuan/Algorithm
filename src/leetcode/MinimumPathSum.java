package leetcode;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[3];
        }
        matrix[0][0] = 1;matrix[0][1] = 3;matrix[0][2] = 1;
        matrix[1][0] = 1;matrix[1][1] = 5;matrix[1][2] = 1;
        matrix[2][0] = 4;matrix[2][1] = 2;matrix[2][2] = 1;
        System.out.println(new Solution().minPathSum(matrix));

    }

    static class Solution {
        public int minPathSum(int[][] grid) {
            for (int i = grid.length - 2; i >= 0; i--) {
                grid[i][grid[i].length - 1] = grid[i][grid[i].length - 1] + grid[i + 1][grid[i].length - 1];
            }
            for (int j = grid[0].length - 2; j >= 0; j--) {
                grid[grid.length - 1][j] = grid[grid.length - 1][j] + grid[grid.length - 1][j + 1];
            }

            for (int i = grid.length - 2; i >= 0; i--) {
                for (int j = grid[i].length - 2; j >= 0; j--) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
                }
            }

            return grid[0][0];
        }
    }
}
