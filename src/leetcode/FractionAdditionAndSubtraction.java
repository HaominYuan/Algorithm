package leetcode;

public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        System.out.println(new Solution().fractionAddition("29/6-3/10"));
    }

    static class Solution {
        int resultNumerator = 0;
        int resultDenominator = 1;
        public String fractionAddition(String expression) {
            if (expression.charAt(0) != '-') {
                expression = '+' + expression;
            }

            int symbol = 0;
            int numerator = 0;
            int denominator = 0;
            int operator = 0;


            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '-') {
                    if (operator != 0) {
                        func(operator, numerator, denominator);
                        numerator = 0;
                        denominator = 0;
                    }
                    operator = 1;
                    symbol = 0;
                } else if (expression.charAt(i) == '+') {
                    if (operator != 0) {
                        func(operator, numerator, denominator);
                        numerator = 0;
                        denominator = 0;
                    }
                    operator = 2;
                    symbol = 1;
                } else if (expression.charAt(i) == '/') {
                    symbol = 2;
                } else {
                    if (symbol == 2) {
                        denominator = denominator * 10 + (expression.charAt(i) - '0');
                    } else {
                        numerator = numerator * 10 + (expression.charAt(i) - '0');
                        symbol = 3;
                    }
                }
            }


            if (operator != 0) {
                func(operator, numerator, denominator);
            }

            return resultNumerator + "/" + resultDenominator;
        }

        void func(int operator, int numerator, int denominator) {
            int commonMultiple = LCM(denominator, resultDenominator);
            if (operator == 1) {
                resultNumerator = resultNumerator * commonMultiple / resultDenominator - numerator * commonMultiple / denominator;
            } else {
                resultNumerator = resultNumerator * commonMultiple / resultDenominator + numerator * commonMultiple / denominator;
            }
            resultDenominator = commonMultiple;
            if (resultNumerator == 0) {
                resultDenominator = 1;
            } else {
                int commonDivisor = GCD(resultNumerator , resultDenominator);
                resultNumerator = resultNumerator / commonDivisor;
                resultDenominator = resultDenominator / commonDivisor;
            }

            if (resultDenominator < 0) {
                resultNumerator = -resultNumerator;
                resultDenominator = -resultDenominator;
            }


        }

        private int GCD(int a, int b) {
            return a % b == 0 ? b : GCD(b, a % b);
        }
        private int LCM(int a, int b) {
            return a * b / GCD(a, b);
        }


    }
}
