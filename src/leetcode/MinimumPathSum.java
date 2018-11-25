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
            if (grid.length == 0) {
                return 0;
            }
            for (int j = 1; j < grid[0].length; j++) {
                grid[0][j] = grid[0][j - 1] + grid[0][j];
            }
            for (int i = 1; i < grid.length; i++) {
                grid[i][0] = grid[i - 1][0] + grid[i][0];
            }
            for (int i = 1; i < grid.length; i++) {
                for (int j = 1; j < grid[0].length; j++) {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
            return grid[grid.length - 1][grid[0].length - 1];
        }
    }
}
