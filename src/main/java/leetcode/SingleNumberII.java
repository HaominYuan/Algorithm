package leetcode;

public class SingleNumberII {
    public static void main(String[] args) {
        System.out.println(new Solution().singleNumber(new int[]{2, 2, 2, 3, 4, 4, 4}));
    }

    static class NaiveSolution {
        public int singleNumber(int[] nums) {
            int result = 0, sum = 0, s = 1;
            for (int i = 0; i < 32; i++) {
                for (int num : nums) {
                    if ((num & s) != 0) {
                        sum = sum + 1;
                    }
                }
                if (sum % 3 != 0) {
                    result = result | s;
                }
                s = s << 1;
                sum = 0;
            }
            return result;
        }
    }

    static class Solution {
        public int singleNumber(int[] nums) {
            int a = 0, b = 0;
            for (int c : nums) {
                b = b ^ c & ~a;
                a = a ^ c & ~b;
            }
            return b;
        }
    }
}
