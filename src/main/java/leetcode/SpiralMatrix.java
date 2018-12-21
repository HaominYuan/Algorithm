package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[3];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i * 3 + j + 1;
            }
        }

        System.out.println(new Solution().spiralOrder(matrix));
    }

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            if (matrix.length == 0) {
                return new ArrayList<>();
            }


            int[] nums = new int[4];
            nums[0] = matrix[0].length;
            nums[1] = matrix.length;
            nums[2] = -1;
            nums[3] = 0;
            int i = 0, j = 0, k = 0;
            List<Integer> list = new ArrayList<>();
            while (true) {
                list.add(matrix[i][j]);
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
            return list;
        }
    }
}
