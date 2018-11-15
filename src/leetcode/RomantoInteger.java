package leetcode;

public class RomantoInteger {
    public static void main(String[] args) {
        String instance = "III";
        System.out.println(Solution.romanToInt(instance));
        instance = "IV";
        System.out.println(Solution.romanToInt(instance));
        instance = "IX";
        System.out.println(Solution.romanToInt(instance));
        instance = "LVIII";
        System.out.println(Solution.romanToInt(instance));
        instance = "MCMXCIV";
        System.out.println(Solution.romanToInt(instance));

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
        static int romanToInt(String s) {
            int result = 0;
            boolean iFlag = false;
            boolean xFlag = false;
            boolean cFlag = false;
            for (int i = 0; i < s.length(); i++) {
                switch (s.charAt(i)) {
                    case 'I':
                        if (cFlag) {
                            result = result + 100;
                            cFlag = false;
                        }

                        if (xFlag) {
                            result = result + 10;
                            xFlag = false;
                        }

                        if (!iFlag) {
                            iFlag = true;
                        } else {
                            result = result + 2;
                            iFlag = false;
                        }
                        break;
                    case 'V':
                        if (cFlag) {
                            result = result + 100;
                            cFlag = false;
                        }

                        if (xFlag) {
                            result = result + 10;
                            xFlag = false;
                        }

                        if (iFlag) {
                            result = result + 4;
                            iFlag = false;
                        } else {
                            result = result + 5;
                        }
                        break;
                    case 'X':
                        if (cFlag) {
                            result = result + 100;
                            cFlag = false;
                        }
                        if (iFlag) {
                            result = result + 9;
                            iFlag = false;
                        } else {
                            if (!xFlag) {
                                xFlag = true;
                            } else {
                                result = result + 20;
                                xFlag = false;
                            }
                        }

                        break;
                    case 'L':
                        if (cFlag) {
                            result = result + 100;
                            cFlag = false;
                        }
                        if (xFlag) {
                            result = result + 40;
                            xFlag = false;
                        } else {
                            result = result + 50;
                        }


                        break;
                    case 'C':
                        if (xFlag) {
                            result = result + 90;
                            xFlag = false;
                        } else {
                            if (!cFlag) {
                                cFlag = true;
                            } else {
                                result = result + 200;
                                cFlag = false;
                            }
                        }
                        break;
                    case 'D':
                        if (cFlag) {
                            result = result + 400;
                            cFlag = false;
                        } else {
                            result = result + 500;
                        }
                        break;
                    case 'M':
                        if (cFlag) {
                            result = result + 900;
                            cFlag = false;
                        } else {
                            result = result + 1000;
                        }
                        break;
                }
            }
            if (cFlag) {
                result = result + 100;
            }
            if (xFlag) {
                result = result + 10;
            }
            if (iFlag) {
                result = result + 1;
            }
            return result;
        }
    }
}
