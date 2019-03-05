package leetcode;

public class SearchA2DMatrixII {
    public static void main(String[] args) {
//        [1,   4,  7, 11, 15],
//        [2,   5,  8, 12, 19],
//        [3,   6,  9, 16, 22],
//        [10, 13, 14, 17, 24],
//        [18, 21, 23, 26, 30]
        int[][] matrix = new int[5][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[5];
        }
        matrix[0][0] = 1;matrix[0][1] = 1;
        matrix[0][2] = 7;matrix[0][3] = 11;matrix[0][4] = 15;
        matrix[1][0] = 2;matrix[1][1] = 5;matrix[1][2] = 8;matrix[1][3] = 12;matrix[1][4] = 19;
        matrix[2][0] = 4;matrix[2][1] = 6;matrix[2][2] = 9;matrix[2][3] = 16;matrix[2][4] = 22;
        matrix[3][0] = 10;matrix[3][1] = 13;matrix[3][2] = 14;matrix[3][3] = 17;matrix[3][4] = 24;
        matrix[4][0] = 18;matrix[4][1] = 21;matrix[4][2] = 23;matrix[4][3] = 26;matrix[4][4] = 30;
        System.out.println(new MySolution().searchMatrix(matrix, 5));
    }

    static class MySolution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
            int j = matrix[0].length - 1;
            while (j >= 0) {
                if (matrix[0][j] > target || matrix[matrix.length - 1][j] < target) {
                    j = j - 1;
                } else if (find(matrix, j, target)) {
                    return true;
                } else {
                    j = j - 1;
                }
            }
            return false;
        }

        boolean find(int[][] matrix, int j, int target) {
            int begin = 0, end = matrix.length - 1;
            while (begin <= end) {
                int mid = (begin + end) / 2;
                if (matrix[mid][j] == target) {
                    return true;
                }
                if (matrix[mid][j] < target) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return false;
        }
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return false;
            }
//            int j = matrix[0].length - 1, i = 0;
//            while (i < matrix.length && j >= 0) {
//                if (matrix[i][j] == target) {
//                    return true;
//                }
//                if (matrix[i][j] > target) {
//                    j = j - 1;
//                } else {
//                    i = i + 1;
//                }
//            }


            int i = matrix.length - 1, j = 0;
            while (i >= 0 && j < matrix[0].length) {
                if (matrix[i][j] == target) {
                    return true;
                }

                if (matrix[i][j] < target) {
                    i = i - 1;
                } else {
                    j = j + 1;
                }
            }
            return false;
        }


    }
}
