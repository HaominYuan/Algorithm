package leetcode;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[3];
        }
        matrix[0][0] = 1;
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][2] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][2] = 1;
        new Solution().setZeroes(matrix);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }

    }

    static class Solution {
        public void setZeroes(int[][] matrix) {
            boolean[] markedX = new boolean[matrix.length];
            boolean[] markedY = new boolean[matrix[0].length];


            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == 0) {
                        markedX[i] = true;
                        markedY[j] = true;
                    }
                }
            }
            for (int i = 0; i < markedX.length; i++) {
                for (int j = 0; j < markedY.length; j++) {
                    if (markedX[i] || markedY[j]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
    }

}
