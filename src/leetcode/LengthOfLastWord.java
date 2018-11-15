package leetcode;

public class LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("Hello World"));

    }

    static class Solution {
        public int lengthOfLastWord(String s) {
            if (s.length() == 0) {
                return 0;
            }
            int count = 0;
            boolean flag = false;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (s.charAt(i) != ' ') {
                    count = count + 1;
                    flag = true;
                } else if (flag) {
                    return count;
                }
            }
            return count;
        }
    }
}
