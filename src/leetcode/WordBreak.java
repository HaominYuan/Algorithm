package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(new Solution().wordBreak("leetcode", wordDict));
    }

    static class NaiveSolution {
        public boolean wordBreak(String s, List<String> wordDict) {
            wordDict.sort((o1, o2) -> Integer.compare(o2.length(), o1.length()));
            return func(s, wordDict);
        }


        boolean func(String s, List<String> wordDict) {
            if (s.equals("")) {
                return true;
            }

            for (int i = 0; i < wordDict.size(); i++) {
                if (s.startsWith(wordDict.get(i)) && wordBreak(s.substring(wordDict.get(i).length()), wordDict)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            int maxLength = Integer.MIN_VALUE;
            for (String s1 : wordDict) {
                maxLength = Math.max(maxLength, s1.length());
            }
            boolean[] marked = new boolean[s.length() + 1];
            marked[0] = true;
            for (int i = 1; i < marked.length; i++) {
                for (int j = Math.max(0, i - maxLength); j < i; j++) {
                    if (marked[j] && wordDict.contains(s.substring(j, i))) {
                        marked[i] = true;
                        break;
                    }
                }
            }
            return marked[s.length()];
        }
    }

}
