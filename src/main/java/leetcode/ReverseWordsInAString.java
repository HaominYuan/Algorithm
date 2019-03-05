package leetcode;


public class ReverseWordsInAString {
    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords(""));
    }

    static class Solution {
        public String reverseWords(String s) {
            if (s == null || "".equals(s)) {
                return "";
            }
            s = s.trim();
            StringBuilder reverse = new StringBuilder();
            String[] arr = s.split(" ");
            for (int i = arr.length - 1; i >= 0; i--) {
                if ("".equals(arr[i])) {
                    continue;
                }
                reverse.append(arr[i]);
                if (i > 0) {
                    reverse.append(" ");
                }
            }
            return reverse.toString();
        }
    }
}
