package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = new String[]{"flower", "flow"};
        System.out.println(Solution.longestCommonPrefix(strings));
    }


    static class Solution {
        static String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            try {
                int index = 0;
                while (true) {
                    char temp = strs[0].charAt(index);
                    for (int i = 1; i < strs.length; i++) {
                        if (strs[i].charAt(index) != temp) {
                            return result.toString();
                        }
                    }
                    result.append(temp);
                    index++;
                }
            } catch (Exception e) {
                return result.toString();
            }
        }
    }
}
