package leetcode;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] matix = new char[4][];
        for (int i = 0; i < matix.length; i++) {
            matix[i] = new char[5];
        }
        matix[0][0] = '1';matix[0][1] = '0';matix[0][2] = '1';matix[0][3] = '0';matix[0][4] = '0';
        matix[1][0] = '1';matix[1][1] = '0';matix[1][2] = '1';matix[1][3] = '1';matix[1][4] = '1';
        matix[2][0] = '1';matix[2][1] = '1';matix[2][2] = '1';matix[2][3] = '1';matix[2][4] = '1';
        matix[3][0] = '1';matix[3][1] = '0';matix[3][2] = '0';matix[3][3] = '1';matix[3][4] = '0';
        new Solution().maximalRectangle(matix);
    }


    static class Solution {
        public int maximalRectangle(char[][] matrix) {
            return 1;
        }
    }
}
