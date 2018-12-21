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
     *
     * 注意考虑两种情况，一个是所有都不一样，一个是所有都一样
     * 初始化为零意味着当所有都是不一样的时候，我们初始化为0，所以我们少了一个1，所以我们在计算长度的时候要加上1
     * 因为初始化都是0，所以我们有面出现字符是要加1
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
