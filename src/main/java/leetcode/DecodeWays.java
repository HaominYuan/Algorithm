package leetcode;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("12"));
    }

    static class Solution {
        int numDecodings(String s) {
            if (s.length() == 0 || s.charAt(0) == '0')
                return 0;

            int current = 1;
            int last = 1;
            for (int i = 1; i < s.length(); i++) {
                int tmp = current;
                if (s.charAt(i) == '0') {
                    if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                        current = last;
                    } else {
                        return 0;
                    }
                } else if (s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    current = current + last;
                }
                last = tmp;
            }
            return current;
        }
    }
}
