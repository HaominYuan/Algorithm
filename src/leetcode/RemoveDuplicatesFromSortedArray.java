package leetcode;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(Solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }


    static class Solution {
        static int removeDuplicates(int[] nums) {
            int start = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] != nums[i + 1]) {
                    start++;
                    nums[start] = nums[i + 1];
                }
            }
            return start + 1;
        }
    }
}
