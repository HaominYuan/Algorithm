package leetcode;

public class ZigZag {
    public static void main(String[] args) {
        System.out.println(Solution.convert("P", 1));
        System.out.println(Solution.convert("PAYPALISHIRING", 4));
    }




    static class Solution {
        static String convert(String s, int numRows) {
            if (numRows == 1) {
                return s;
            }
            int T = (numRows - 1) * 2;
            StringBuilder[] newS = new StringBuilder[numRows];
            for (int i = 0; i < newS.length; i++) {
                newS[i] = new StringBuilder();
            }
            for (int i = 0; i * T < s.length(); i++) {
                for (int j = 0; j < numRows; j++) {
                    if (j + i * T < s.length()) {
                        newS[j].append(s.charAt(j + i * T));
                        int symmetry = T - j;
                        if (symmetry != T && symmetry != j && i * T + symmetry < s.length()) {
                            newS[j].append(s.charAt(i * T + symmetry));
                        }
                    }
                }
            }
            for (int i = 1; i < numRows; i++) {
                newS[0].append(newS[i]);
            }
            return newS[0].toString();
        }
    }
}