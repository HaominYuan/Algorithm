package leetcode;

import java.util.*;

public class LargestNumber {
    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Solution().largestNumber(new int[]{128, 12}));
    }

    static class Solution {
        public String largestNumber(int[] nums) {
            String[] str = new String[nums.length];
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                str[i] = nums[i] + "";
            }
            Comparator<String> cmp = (str1, str2) -> {
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            };
            Arrays.sort(str, cmp);

            for (String aStr : str) {
                result.append(aStr);
            }

            if (result.charAt(0) == '0') {
                return "0";
            }
            return result.toString();
        }
    }
}
