package leetcode;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }

    static class Solution {
        public List<String> restoreIpAddresses(String s) {
            List<String> list = new ArrayList<>();
            if (s.length() < 4 || s.length() > 12) {
                return list;
            }
            func(s, 0, list, 0, "");
            return list;
        }

        void func(String s, int index, List<String> list, int time, String result) {
            if (index == s.length() && time == 4) {
                list.add(result.substring(0, result.length() - 1));
                return;
            }

            if (index == s.length() || time == 4) {
                return;
            }


            if (s.charAt(index) == '0') {
                func(s, index + 1, list, time + 1, result + s.charAt(index) + ".");
                return;
            }

            func(s, index + 1, list, time + 1, result + s.charAt(index) + ".");

            if (index + 1 < s.length()) {
                func(s, index + 2, list, time + 1, result + s.charAt(index) + s.charAt(index + 1) + ".");
            }

            if (s.charAt(index) == '1') {
                if (index + 2 < s.length()) {
                    func(s, index + 3, list, time + 1, result + s.substring(index, index + 3) + ".");
                }
                return;
            }

            if (s.charAt(index) == '2') {
                if (index + 2 < s.length() && (s.charAt(index + 1) <= '4' || (s.charAt(index + 1) == '5' && s.charAt(index + 2) <= '5'))) {
                    func(s, index + 3, list, time + 1, result + s.substring(index, index + 3) + ".");
                }
            }
        }
    }
}
