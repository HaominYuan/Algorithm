package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow", "flight"};
        System.out.println(new Solution().longestCommonPrefix(strings));
    }


    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }
            return func(strs, 0, strs.length - 1);
        }

        String func(String[] strings, int left, int right) {
            if (left == right) {
                return strings[left];
            }
            int mid = (left + right) / 2;
            String leftLongest = func(strings, left, mid);
            if (leftLongest.length() == 0) {
                return "";
            }
            String rightLongest = func(strings, mid + 1, right);
            int minLength = Math.min(leftLongest.length(), rightLongest.length());
            for (int i = 0; i < minLength; i++) {
                if (leftLongest.charAt(i) != rightLongest.charAt(i)) {
                    return leftLongest.substring(0, i);
                }
            }
            return leftLongest.substring(0, minLength);
        }
    }
}
