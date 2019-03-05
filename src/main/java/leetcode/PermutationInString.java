package leetcode;

public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(new Solution().checkInclusion("ab", "eidbaooo"));
    }

    static class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            int[] count = new int[128];
            for (int i = 0; i < s2.length(); i++) {
                count[s2.charAt(i)] = count[s2.charAt(i)] + 1;
            }

            for (int i = 0; i < s1.length(); i++) {
                if ((count[s1.charAt(i)] = count[s1.charAt(i)] - 1) < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
