package leetcode;

import java.util.LinkedList;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(new MySolution().countPrimes(n));
    }


    static class MySolution {
        public int countPrimes(int n) {
            int count = 0;
            int temp;
            boolean[] booleans = new boolean[n];
            for (int i = 2; i < n; i++) {
                if (!booleans[i]) {
                    count = count + 1;
                    for (int j = 2; (temp = j * i) < n; j++) {
                        booleans[temp] = true;
                    }
                }
            }
            return count;
        }

    }


    static class Solution {
        public int countPrimes(int n) {
            if (n <= 2) {
                return 0;
            }
            LinkedList<Integer> linkedList1 = new LinkedList<>();
            LinkedList<Integer> linkedList2 = new LinkedList<>();

            for (int i = 2; i < n; i++) {
                linkedList1.add(i);
            }
            int sum = 0;
            while (!linkedList1.isEmpty()) {
                // 将第一个数组中的数拿出来
                int number = linkedList1.remove();
                if (isPrime(number)) {
                    sum = sum + 1;
                }
                for (Integer integer : linkedList1) {
                    if (integer % number != 0) {
                        linkedList2.add(integer);
                    }
                }
                linkedList1 = linkedList2;
                linkedList2 = new LinkedList<>();
            }
            return sum;
        }


        boolean isPrime(int number) {
            if (number == 1) {
                return false;
            }
            // 这里注意了范围和被判定的数是不一样的，小心弄错
            int limit = (int) Math.sqrt(number);
            for (int i = 2; i <= limit; i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }


    static class NaiveSolution {
        public int countPrimes(int n) {
            if (n <= 1) {
                return 0;
            }
            int sum = n - 1;
            n = n - 1;
            for (int i = 0; i < n; i++) {
                if (!isPrime(i + 1)) {
                    sum = sum - 1;
                }
            }
            return sum;
        }

        boolean isPrime(int number) {
            if (number == 1) {
                return false;
            }
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    return false;
                }
            }
            return true;

        }
    }
}
