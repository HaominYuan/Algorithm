package leetcode;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseString("A man, a plan, a canal: Panama"));
    }

    static class Solution {
        public String reverseString(String s) {
            int i = 0, j = s.length() - 1;
            char[] chars = s.toCharArray();
            while (i < j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i = i + 1;
                j = j - 1;
            }
            return new String(chars);
        }
    }
}
