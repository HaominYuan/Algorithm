package leetcode;

import java.util.Arrays;

public class PlusOne {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().plusOne(new int[]{9})));
    }

    static class Solution {
        public int[] plusOne(int[] digits) {
            int number = digits[0];
            for (int i = 1; i < digits.length; i++) {
                number = number * 10 + digits[i];
            }
            number = number + 1;




            int s = 1, i;
            for (i = digits.length - 1; i >= 0; i--) {
                digits[i] = digits[i] + s;
                if (digits[i] != 10) {
                    break;
                }
                digits[i] = 0;
            }
            if (i != -1) {
                return digits;
            }
            int[] temp = new int[digits.length + 1];
            temp[0] = 1;
            return temp;
        }
    }
}
