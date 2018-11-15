package leetcode;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * @ProjectName: leetcode
 * @Description: java类作用描述
 * @Author: Tst
 * @CreateDate: 2018/8/12 下午7:28
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String string1 = "aacdefcaa";
//        string1 = "ddabac";
        System.out.println(Solution.longestPalindrome(string1));
    }


    static int getPalindromeLength(String string) {
        // 1、构造新的字符串
        // 为了避免奇数回文和偶数回文的不同处理问题，在原字符串中插入'#'， 将所有回文变成奇数回文
        StringBuilder newStr = new StringBuilder();
        newStr.append('#');
        for (int i = 0; i < string.length(); i++) {
            newStr.append(string.charAt(i));
            newStr.append('#');
        }

        // radius[i]表示以i为中心的回文的最大半径，i至少为1，即该字符本身
        int[] radius = new int[newStr.length()];
        // right表示已知的回文中，最右的边界的坐标
        int right = -1;
        // id表示已知的回文中，拥有最右边界的回文的中点坐标
        int id = -1;
        // 2、计算所有的rad
        // 这个算法是O(n)的原因是right只会随着里层while的迭代而增长，不会减少。
        for (int i = 0; i < newStr.length(); i++) {
            // 2.1、确定一个最小的半径
            int r = 1;
            if (i <= right) {
                r = Math.min(radius[id] + id - i, radius[2 * id - i]);
            }
            // 2.2、尝试更大的半径
            while (i - r >= 0 && i + r < newStr.length() && newStr.charAt(i - r) == newStr.charAt(i + r)) {
                r++;
            }
            // 2.3、更新边界和回文中心的坐标
            if (i + r - 1 > right) {
                right = i + r - 1;
                id = i;
            }
            radius[i] = r;

        }

        // 3、扫描一遍radius数组，找出最大的半径
        int maxLength = 0;
        for (int r : radius) {
            if (r > maxLength) {
                maxLength = r;
            }
        }

//        假如字符串是 #2#1#2# 显然最大的长度是 4 - 1
        return maxLength - 1;
    }

    static class Solution {
        static String longestPalindrome(String s) {
            StringBuilder newS = new StringBuilder();
            newS.append("$#");
            for (int i = 0; i < s.length(); i++) {
                newS.append(s.charAt(i));
                newS.append('#');
            }
            newS.append('\n');
            int[] p = new int[newS.length() - 1];
            int mx = 0;
            int id = 0;
            int maxLen = -1;
            String result = "";

            for (int i = 1; i < newS.length() - 1; i++) {
                // 判断是否在范围内
                if (i < mx) {
                    p[i] = p[2 * id - i] < mx - i ? p[2 * id - i] : mx - i;
                } else {
                    // 不再范围内则需要另起炉灶
                    p[i] = 1;
                }

                // 能进入这个循环有两种情况
                // 第一、p[2 * id - i] == mx - i
                // 第二、另起炉灶
                while (newS.charAt(i - p[i]) == newS.charAt(i + p[i])) {
                    p[i] = p[i] + 1;
                }

                if (mx < i + p[i]) {
                    id = i;
                    mx = i + p[i];
                }
                if (maxLen < p[i] - 1) {
                    maxLen = p[i] - 1;
                    if (newS.charAt(i) == '#') {
                        result = s.substring((i - 1) / 2 - (p[i] - 1) / 2, (i - 1) / 2 + (p[i] - 1) / 2);
                    } else {
                        result = s.substring(i / 2 - 1 - (p[i] / 2 - 1), i / 2 - 1 + p[i] / 2);
                    }
                }
            }
            return result;
        }

    }

    static class MySolution {
        static String longestPalindrome(String s) {
            return func(s);
        }


        private static String func(String string) {
            int length = string.length();
            Queue<String> strings = new ArrayDeque<>();
            strings.add(string);
            Set<String> set = new HashSet<>();
            set.add(string);
            while (!strings.isEmpty()) {
                String temp = strings.poll();
                if (isPalindromic(temp)) {
                    return temp;
                } else {
                    String temp1 = temp.substring(1);
                    String temp2 = temp.substring(0, temp.length() - 1);
                    if (temp1.length() < length) {
                        length = temp1.length();
                        set.clear();
                    }
                    if (!set.contains(temp1)) {
                        set.add(temp1);
                        strings.add(temp1);
                    }
                    if (!set.contains(temp2)) {
                        set.add(temp2);
                        strings.add(temp2);
                    }
                }
            }
            return "";
        }

        private static boolean isPalindromic(String string) {
            for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
                if (string.charAt(i) != string.charAt(j)) {
                    return false;
                }
            }
            return true;
        }
    }
}
