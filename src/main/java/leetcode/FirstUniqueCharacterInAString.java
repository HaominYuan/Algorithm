package leetcode;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        System.out.println(new MySolution().firstUniqueChar("ll"));
    }

    static class MySolution {
        public int firstUniqueChar(String s) {
            int[] index = new int[26];
            for (int i = 0; i < s.length(); i++) {
                index[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (index[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }

    }


    /**
     * 首先判断是不是唯一字符
     * 随后比下标
     */
    static class Solution {
        public int firstUniqChar(String s) {
            int res = -1;

            for (char ch = 'a'; ch <= 'z'; ch++) {
                int index = s.indexOf(ch);
                if (index != -1 && index == s.lastIndexOf(ch)) {
                    res = res == -1 ? index : Math.min(res, index);
                }
            }
            return res;
        }
    }


}
