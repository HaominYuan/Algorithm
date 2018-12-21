package leetcode;

public class NumberOfIslands {
    public static void main(String[] args) {
        char[][] grid = new char[4][5];
        String s = "11110110101100000000";
        for (int i = 0, k = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = s.charAt(k++);
            }
        }
        System.out.println(new Solution().numIslands(grid));
    }

    static class Solution {
        public int numIslands(char[][] grid) {
            if (grid.length == 0) {
                return 0;
            }
            int sum = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == '1') {
                        sum = sum + 1;
                        func(grid, i, j);
                    }
                }
            }
            return sum;
        }

        void func(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
                return;
            }

            grid[i][j] = '0';
            func(grid, i - 1, j);
            func(grid, i + 1, j);
            func(grid, i, j - 1);
            func(grid, i, j + 1);
        }
    }
}
