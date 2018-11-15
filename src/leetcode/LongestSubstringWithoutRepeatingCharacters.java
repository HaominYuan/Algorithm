package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: leetcode
 * @Description: java类作用描述
 * @Author: Tst
 * @CreateDate: 2018/7/23 下午6:59
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(Solution.lengthOfLongestSubstring(s));
        s = "a.cpp";
        System.out.println(Solution.lengthOfLongestSubstring(s));
        s = "abba";
        System.out.println(Solution.lengthOfLongestSubstring(s));
        s = "pwwkew";
        System.out.println(Solution.lengthOfLongestSubstring(s));
    }


    /**
     * 首先判断前面是否出现，如果出现，则需要比较初始指针和出现字符的位置。移动初始指针，这样就可以把一个串变成一个新串
     * 随后计算长度，此时比较新串长度和旧串大小
     * 把出现的字符的位置放入map中
     * 因为char天然就是一个map，而且key值特别小所以可以直接用数组来模拟map。
     */
    static class Solution {
        static int lengthOfLongestSubstring(String s) {
            int length = s.length(), ans = 0;
            int[] index = new int[128];
            for (int i = 0, j = 0; j < length; j++) {
                i = Math.max(i, index[s.charAt(j)]);
                ans = Math.max(j - i + 1, ans);
                index[s.charAt(j)] = j + 1;
            }
            return ans;
        }
    }
}
