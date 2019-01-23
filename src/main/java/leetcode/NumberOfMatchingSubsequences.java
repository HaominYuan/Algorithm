package leetcode;

import java.util.HashSet;

public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        System.out.println(new Solution().numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    static class Solution {
        public int numMatchingSubseq(String S, String[] words) {
            int sum = 0;
            HashSet<String> set1 = new HashSet<>();
            HashSet<String> set2 = new HashSet<>();
            for (String word : words) {
                if (!set2.contains(word) && (set1.contains(word) || isSubsequence(S, word))) {
                    sum = sum + 1;
                    set1.add(word);
                } else {
                    set2.add(word);
                }

            }
            return sum;
        }

        private boolean isSubsequence(String s, String word) {
            int index = -1;
            for (char c : word.toCharArray()) {
                index = s.indexOf(c, index + 1);
                if (index == -1) {
                    return false;
                }
            }

            return true;
        }
    }


}
