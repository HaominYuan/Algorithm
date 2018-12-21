package leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }

    static class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            ArrayList<List<String>> list = new ArrayList<>();
            int now = 0;
            for (String str : strs) {
                String temp = func(str);
                if (hashMap.containsKey(temp)) {
                    list.get(hashMap.get(temp)).add(str);
                } else {
                    hashMap.put(temp, now++);
                    List<String> tempList = new ArrayList<>();
                    tempList.add(str);
                    list.add(tempList);
                }
            }
            return list;
        }

        private String func(String str) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            return new String(chars);
        }
    }
}
