package leetcode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        System.out.println(Solution.letterCombinations("8"));
    }

    static class Solution {
        static List<String> letterCombinations(String digits) {
            if (digits.length() == 0) {
                return new ArrayList<>();
            }
            Queue<String> queue = new ArrayDeque<>();
            queue.add("");
            HashMap<Character, String> hashMap = new HashMap<>();
            hashMap.put('2', "abc");
            hashMap.put('3', "def");
            hashMap.put('4', "ghi");
            hashMap.put('5', "jkl");
            hashMap.put('6', "mno");
            hashMap.put('7', "pqrs");
            hashMap.put('8', "tuv");
            hashMap.put('9', "wsyz");
            for (int i = 0; i < digits.length(); i++) {
                while (true) {
                    String temp = queue.peek();
                    if (temp.length() > i) {
                        break;
                    }
                    queue.remove();
                    String chars = hashMap.get(digits.charAt(i));
                    for (int j = 0; j < chars.length(); j++) {
                        queue.add(temp + chars.charAt(j));
                    }
                }

            }
            return new ArrayList<>(queue);
        }
    }
}
