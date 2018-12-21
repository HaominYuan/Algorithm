package leetcode;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
    }

    static class Solution {
        public String addBinary(String a, String b) {
            int size = Math.min(a.length(), b.length());
            StringBuilder result = new StringBuilder();
            char s = 0;
            int i, j, k;
            for (i = 0, j = a.length() - 1, k = b.length() - 1; i < size; i++, j--, k--) {
                int temp = a.charAt(j) + b.charAt(k) + s - 96;
                if (temp == 0) {
                    result.insert(0, '0');
                    s = 0;
                } else if (temp == 1) {
                    result.insert(0, '1');
                    s = 0;
                } else if (temp == 2) {
                    result.insert(0, '0');
                    s = 1;
                } else {
                    result.insert(0, '1');
                    s = 1;
                }
            }

            while (j >= 0) {
                int temp = a.charAt(j--) + s - 48;
                if (temp == 0) {
                    result.insert(0, '0');
                    s = 0;
                } else if (temp == 1) {
                    result.insert(0, '1');
                    s = 0;
                } else if (temp == 2) {
                    result.insert(0, '0');
                }
            }

            while (k >= 0) {
                int temp = b.charAt(k--) + s - 48;
                if (temp == 0) {
                    result.insert(0, '0');
                    s = 0;
                } else if (temp == 1) {
                    result.insert(0, '1');
                    s = 0;
                } else if (temp == 2) {
                    result.insert(0, '0');
                }
            }

            if (s == 1) {
                result.insert(0, '1');
            }
            return result.toString();
        }
    }

}
