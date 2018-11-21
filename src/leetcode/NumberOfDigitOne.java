package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NumberOfDigitOne {
    public static void main(String[] args) {
        Solution solution1 = new Solution();
        System.out.println(solution1.countDigitOne(101));
    }

    static class NaiveSolution {
        public int countDigitOne(int n) {
            int sum = 0;
            for (int i = 0; i <= n; i++) {
                sum = sum + isContainDigitOne(i);
            }
            return sum;
        }

        private int isContainDigitOne(int number) {
            int sum = 0;
            while (number != 0) {
                if (number % 10 == 1) {
                    sum = sum + 1;
                }
                number = number / 10;
            }
            return sum;
        }
    }

    static class MySolution {
        public int countDigitOne(int n) {
            if (n <= 0) {
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            while (n != 0) {
                stack.add((n % 10));
                n = n / 10;
            }
            double[] power = new double[stack.size()];
            power[0] = 1;
            for (int i = 1; i < power.length; i++) {
                power[i] = power[i - 1] * 9;
            }

            double sum = 0;
            int count = 0;
            while (!stack.isEmpty()) {
                // 首位
                int m = stack.pop();
                if (m == 0) {
                    continue;
                }
                // 零的位数
                int k = stack.size();

                if (m != 1) {
                    for (int i = k; i >= 0; i--) {
                        sum = sum + comb((long) k, (long) i) * power[k - i] * ((i + count) * m + 1);
                    }
                } else {
                    // 不能全是零否则重复
                    for (int i = k; i >= 0; i--) {
                        sum = sum + comb((long) k, (long) i) * power[k - i] * (i + count);
                    }
                    // k位全是后面全是零
                    sum = sum + 1;
                    count = count + 1;
                }
            }
            return (int) sum;
        }

        static Map<String, Long> map = new HashMap<>();

        private static Long comb(Long m, Long n) {
            String key = m + "" + n;
            if (n == 0)
                return 1L;
            if (n == 1)
                return m;
            if (n > m / 2)
                return comb(m, m - n);
            if (n > 1) {
                if (!map.containsKey(key))
                    map.put(key, comb(m - 1, n - 1) + comb(m - 1, n));
                return map.get(key);
            }
            return 0L;
        }
    }

    static class Solution {
        public int countDigitOne(int n) {
            if (n <= 0) {
                return 0;
            }
            int count = 0, round = n, former = 0;
            for (int base = 1; base <= n; base = base * 10) {
                int weight = round % 10;
                round = round / 10;
                count = count + round * base;
                if (weight == 1) {
                    count = count + former + 1;
                } else if (weight > 1) {
                    count = count + base;
                }
                former = former + base * weight;
            }
            return count;
        }
    }



}
