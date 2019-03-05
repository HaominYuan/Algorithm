package leetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println('A' - 'a');
        System.out.println(new Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }

    static class Solution {
        public boolean isPalindrome(String s) {
            char[] chars = new char[s.length()];
            int length = 0;
            for (int i = 0; i < s.length(); i++) {
                if (func(s.charAt(i))) {
                    chars[length++] = s.charAt(i);
                } else if (func1(s.charAt(i))) {
                    chars[length++] = (char) (s.charAt(i) + 32);
                }
            }

            {
                int i = 0, j = length - 1;
                while (i < j) {
                    if (chars[i] != chars[j]) {
                        return false;
                    }
                    i = i + 1;
                    j = j - 1;
                }
            }

            return true;
        }

        private boolean func(char c) {
            return 'a' <= c && c <= 'z' || '0' <= c && c <= '9';
        }

        private boolean func1(char c) {
            return 'A' <= c && c <= 'Z';
        }
    }
}
