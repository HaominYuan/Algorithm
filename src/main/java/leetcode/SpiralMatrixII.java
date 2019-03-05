package leetcode;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int[][] matrix = new Solution().generateMatrix(3);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                System.out.print(anAMatrix + " ");
            }
            System.out.println();
        }
    }

    static class Solution {
        public int[][] generateMatrix(int n) {
            int[][] matrix = new int[n][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = new int[n];
            }

            int[] nums = new int[4];
            nums[0] = matrix[0].length;
            nums[1] = matrix.length;
            nums[2] = -1;
            nums[3] = 0;
            int i = 0, j = 0, k = 0, count = 1;
            while (true) {
                matrix[i][j] = count;
                count = count + 1;
                if (k == 0) {
                    if (j + 1 == nums[k]) {
                        nums[k] = nums[k] - 1;
                        k = (k + 1) % 4;


                        if (i + 1 >= nums[k]) {
                            break;
                        } else {
                            i = i + 1;
                        }

                    } else {
                        j = j + 1;
                    }
                } else if (k == 1) {
                    if (i + 1 == nums[k]) {
                        nums[k] = nums[k] - 1;
                        k = (k + 1) % 4;

                        if (j - 1 <= nums[k]) {
                            break;
                        } else {
                            j = j - 1;
                        }

                    } else {
                        i = i + 1;
                    }

                } else if (k == 2) {

                    if (j - 1 == nums[k]) {
                        nums[k] = nums[k] + 1;
                        k = (k + 1) % 4;

                        if (i - 1 <= nums[k]) {
                            break;
                        } else {

                            i = i - 1;
                        }
                    } else {
                        j = j - 1;
                    }


                } else {
                    if (i - 1 == nums[k]) {

                        nums[k] = nums[k] + 1;
                        k = (k + 1) % 4;


                        if (j + 1 >= nums[k]) {
                            break;
                        } else {
                            j = j + 1;
                        }
                    } else {
                        i = i - 1;
                    }
                }
            }
            return matrix;
        }
    }
}
