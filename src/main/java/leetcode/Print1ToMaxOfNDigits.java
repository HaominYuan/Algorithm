package leetcode;

import java.util.Arrays;

public class Print1ToMaxOfNDigits {
    public static void main(String[] args) {
        Print1ToMaxOfNDigits tmp = new Print1ToMaxOfNDigits();
        tmp.print1ToMaxOfDigits_3(2);
    }

    // 未考虑number太大溢出的情况
    private void print1ToMaxOfDigits_1(int n) {
        int number = 1;
        for (int i = 0; i < n; i++) {
            number = number * 10;
        }

        for (int i = 1; i < number; i++) {
            System.out.println(i);
        }
    }

    // 代码太长，书写不方便
    private void print1ToMaxOfDigits_2(int n) {
        StringBuilder number = new StringBuilder();
        for (int i = -1; i < n; i++) {
            number.append('0');
        }

        while (!increment(number)) {
            System.out.println(format(number.toString()));
        }
    }

    private boolean increment(StringBuilder number) {
        int s = 1;
        for (int i = number.length() - 1; s != 0 && i >= 0; i--) {
            int sum = number.charAt(i) - '0' + s;
            s = sum / 10;
            number.setCharAt(i, (char) ('0' + sum % 10));
        }
        return number.charAt(0) != '0';
    }

    private String format(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) != '0') {
                return number.substring(i);
            }
        }
        return null;
    }

    // 递归写法，比较方便
    private void print1ToMaxOfDigits_3(int n) {
        String string = "0123456789";
        char[] chars = new char[n];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = '0';
        }
        func(string, new char[n], n);
    }

    private void func(String string, char[] number, int level) {
        if (level == 0) {
            System.out.println(format(new String(number)));
            return;
        }
        for (int i = 0; i < string.length(); i++) {
            number[number.length - level] = string.charAt(i);
            func(string, number, level - 1);
            number[number.length - level] = '0';
        }
    }






}
