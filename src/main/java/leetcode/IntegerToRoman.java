package leetcode;

public class IntegerToRoman {


    public static void main(String[] args) {
        int instance = 3;
        System.out.println(Solution.intToRoman(instance));
        instance = 4;
        System.out.println(Solution.intToRoman(instance));
        instance = 9;
        System.out.println(Solution.intToRoman(instance));
        instance = 58;
        System.out.println(Solution.intToRoman(instance));
        instance = 1994;
        System.out.println(Solution.intToRoman(instance));
    }


//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000

    static class Solution {
        static String intToRoman(int num) {
            StringBuilder result = new StringBuilder();
            int copy = num;
            int m = num / 1000;
            copy = copy - m * 1000;
            int c = copy / 100;
            copy = copy - c * 100;
            int x = copy / 10;
            copy = copy - x * 10;
            for (int i = 0; i < m; i++) {
                result.append('M');
            }
            if (c == 9) {
                result.append("CM");
            } else if (c == 4) {
                result.append("CD");
            } else {
                if (c >= 5) {
                    result.append('D');
                    c = c - 5;
                }
                for (int i = 0; i < c; i++) {
                    result.append('C');
                }
            }

            if (x == 9) {
                result.append("XC");
            } else if (x == 4) {
                result.append("XL");
            } else {
                if (x >= 5) {
                    result.append('L');
                    x = x - 5;
                }
                for (int i = 0; i < x; i++) {
                    result.append('X');
                }
            }

            if (copy == 9) {
                result.append("IX");
            } else if (copy == 4) {
                result.append("IV");
            } else {
                if (copy >= 5) {
                    result.append('V');
                    copy = copy - 5;
                }
                for (int i = 0; i < copy; i++) {
                    result.append('I');
                }
            }



            return result.toString();
        }
    }
}

