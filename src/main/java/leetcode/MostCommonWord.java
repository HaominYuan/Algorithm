package leetcode;

import java.util.*;

public class MostCommonWord {
    public static void main(String[] args) {
        System.out.println(new Solution().mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[]{"hit"}));
    }

    static class Solution {
        public String mostCommonWord(String paragraph, String[] banned) {
            paragraph = paragraph.toLowerCase() + " ";
            Set<String> set = new HashSet<>(Arrays.asList(banned));
            Map<String, Integer> wordCount = new HashMap<>();
            StringBuilder word = new StringBuilder();
            for (int i = 0; i < paragraph.length(); i++) {
                if ('a' <= paragraph.charAt(i) && paragraph.charAt(i) <= 'z') {
                    word.append(paragraph.charAt(i));
                } else {
                    if (!word.toString().equals("") && !set.contains(word.toString())) {
                        if (wordCount.containsKey(word.toString())) {
                            wordCount.put(word.toString(), wordCount.get(word.toString()) + 1);
                        } else {
                            wordCount.put(word.toString(), 1);
                        }
                    }
                    word = new StringBuilder();
                }
            }

            int max = Integer.MIN_VALUE;
            String wordMax = "";
            for (Map.Entry<String, Integer> temp : wordCount.entrySet()) {
                if (temp.getValue() > max) {
                    max = temp.getValue();
                    wordMax = temp.getKey();
                }
            }
            return wordMax;
        }
    }
}
