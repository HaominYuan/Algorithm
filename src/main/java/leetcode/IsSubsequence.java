package leetcode;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(new MySolution().isSubsequence("abc", "ahbgdc"));
    }

    static class MySolution {
        public boolean isSubsequence(String s, String t) {
            if (s.length() == 0) {
                return true;
            }
            int j = 0;
            for (int i = 0; i < t.length() && j < s.length(); i++) {
                if (t.charAt(i) == s.charAt(j)) {
                    j = j + 1;
                }
            }
            return j == s.length();
        }
    }

    static class Solution {
        public boolean isSubsequence(String s, String t) {
            int index = -1;
            for (char c : s.toCharArray()) {
                index = t.indexOf(c, index + 1);
                if (index == -1) {
                    return false;
                }

            }
            return true;
        }
    }

}
