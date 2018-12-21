package leetcode;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] array = new int[]{2, 0, 2, 1, 1, 0};
        new Solution().sortColors(array);
        System.out.println(Arrays.toString(array));
    }

    static class Solution {
        public void sortColors(int[] nums) {
            int index1 = 0, index2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    int temp = nums[index2];
                    nums[index2++] = 1;
                    nums[i] = temp;
                } else if (nums[i] == 0) {

                    int temp = nums[index2];
                    nums[index2] = 0;
                    nums[i] = temp;
                    temp = nums[index1];
                    nums[index1++] = nums[index2];
                    nums[index2++] = temp;
                }
            }
        }
    }
}
