package leetcode;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[4][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[4];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * 4 + j + 1;
            }
        }
        new Solution().rotate(matrix);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public void rotate(int[][] matrix) {
            int i = 0, j = matrix.length - 1;
            while (i < j) {
                for (int k = 0; k < matrix.length; k++) {
                    int temp = matrix[i][k];
                    matrix[i][k] = matrix[j][k];
                    matrix[j][k] = temp;
                }
                i = i + 1;
                j = j - 1;
            }
            for (i = 0; i < matrix.length; i++) {
                for (j = 0; j < i; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }

    }

}
