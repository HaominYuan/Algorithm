package leetcode;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 2, 3, 4, 4, 4}));
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int test = 0;
            for (int i = 0; i < nums.length; i++) {
                test = test ^ nums[i];
            }

            int test1 = 0;
            for (int i = 0; i < nums.length; i++) {
                test1 = test1 ^ (test ^ nums[i]);
            }

//            if ((((nums.length - 1) / 3) % 2) == 0) {
//                System.out.println("偶数");
//                return test1 ^ test;
//            } else {
//                System.out.println("奇数");
//                return test1;
//            }
            return test1;
        }
    }
}
