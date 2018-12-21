package leetcode;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
//        [0,1,2,2,3,0,4,2], val = 2,
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(Solution.removeElement(nums, 2));
        System.out.println(Arrays.toString(nums));

    }


    static class Solution {
        static int removeElement(int[] nums, int val) {
            int index = 0;
            boolean flag;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[index] = nums[i];
                    index = index + 1;
                }
            }
            return index;
        }

    }

}
