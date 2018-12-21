package leetcode;

public class SearchA2DMatrix {
    public static void main(String[] args) {

        int[][] matrix = new int[3][];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[4];
        }

        matrix[0][0] = 1;
//        matrix[0][1] = 3;
//        matrix[0][2] = 5;
//        matrix[0][3] = 7;
//        matrix[1][0] = 10;
//        matrix[1][1] = 11;
//        matrix[1][2] = 16;
//        matrix[1][3] = 20;
//        matrix[2][0] = 23;
//        matrix[2][1] = 30;
//        matrix[2][2] = 34;
//        matrix[2][3] = 50;

        System.out.println(new Solution().searchMatrix(matrix, 1));
    }

    static class MySolution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix.length == 0) {
                return false;
            }
            int left = 0;
            int right = matrix.length * matrix[0].length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                int midX = mid / matrix[0].length;
                int midY = mid % matrix[0].length;

                if (matrix[midX][midY] == target) {
                    return true;
                }
                if (target < matrix[midX][midY]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }

            }
            return false;
        }
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {

            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }



            int left = 0;
            int right = matrix.length - 1;
            int index = matrix[0].length - 1;
            int mid = 0;
            while (left < right) {
                mid = (left + right) / 2;
                if (target < matrix[mid][0]) {
                    right = mid - 1;
                } else if (matrix[mid][index] < target) {
                    left = mid + 1;
                } else {
                    left = mid;
                    break;
                }
            }


            index = left;
            left = 0;
            right = matrix[0].length - 1;
            while (left <= right) {
                mid = (left + right) / 2;
                if (matrix[index][mid] == target) {
                    return true;
                }
                if (target < matrix[index][mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return false;
        }

    }
}
