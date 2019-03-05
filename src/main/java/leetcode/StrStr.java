package leetcode;

public class StrStr {
    public static void main(String[] args) {
        String haystack = "a.cpp";
        String needle = "abab";
        System.out.println(Solution.strStr(haystack, needle));
    }

    static class Solution {
        static int strStr(String haystack, String needle) {
            if (needle.length() == 0) {
                return 0;
            }
            if (haystack.length() == 0) {
                return -1;
            }
            int[] next = calNext(needle);
            int j = 0, i = 0;
            while (i < haystack.length() && j < needle.length()) {
                if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                    i = i + 1;
                    j = j + 1;
                } else {
                    j = next[j];
                }
            }
            if (j == needle.length()) {
                return i - j;
            } else {
                return -1;
            }
        }

        static int[] calNext(String needle) {
            int[] next = new int[needle.length()];
            next[0] = -1;
            int j = -1, i = 0;
            while (i < next.length - 1) {
                if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                    i = i + 1;
                    j = j + 1;
                    next[i] = j;
                } else {
                    j = next[j];
                }
            }
            return next;
        }
    }

}
