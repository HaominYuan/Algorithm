package leetcode;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = new char[4][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new char[5];
        }
        matrix[0][0] = '1';matrix[0][1] = '0';matrix[0][2] = '1';matrix[0][3] = '0';matrix[0][4] = '0';
        matrix[1][0] = '1';matrix[1][1] = '0';matrix[1][2] = '1';matrix[1][3] = '1';matrix[1][4] = '1';
        matrix[2][0] = '1';matrix[2][1] = '1';matrix[2][2] = '1';matrix[2][3] = '1';matrix[2][4] = '1';
        matrix[3][0] = '1';matrix[3][1] = '0';matrix[3][2] = '0';matrix[3][3] = '1';matrix[3][4] = '0';
        System.out.println(new Solution().maximalRectangle(matrix));
    }


    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            if (matrix.length == 0) {
                return 0;
            }
            int max = 0;
            int[] area = new int[matrix[0].length];
            for (int j = 0; j < matrix[0].length; j++) {
                area[j] = matrix[0][j] == '1' ? 1 : 0;
            }

            max = Math.max(max, largestInLine(area));
            for (int i = 1; i < matrix.length; i++) {

                for (int j = 0; j < matrix[i].length; j++) {
                    area[j] = matrix[i][j] == '1' ? area[j] + 1 : 0;
                }
                max = Math.max(max, largestInLine(area));
            }
            return max;
        }


        private int largestInLine(int[] height) {
            if (height == null || height.length < 1)
                return 0;
            int[] stack = new int[height.length + 1];
            int len = 0, max = 0;
            for (int i = 0; i <= height.length; i++) {
                int h = (i == height.length) ? 0 : height[i];
                while (len != 0 && (i == height.length || height[stack[len - 1]] > h)) {
                    if (len == 1)
                        max = Math.max(height[stack[--len]] * i, max);
                    else
                        max = Math.max(height[stack[--len]] * (i - stack[len - 1] - 1), max);
                }
                stack[len++] = i;
            }
            return max;
        }

    }

}
