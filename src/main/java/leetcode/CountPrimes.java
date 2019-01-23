package leetcode;

import java.util.LinkedList;

public class CountPrimes {

    public static void main(String[] args) {
        int n = 499979;
        System.out.println(new NaiveSolution().countPrimes(n));
    }

//    static class MySolution {
//        public int countPrimes(int n) {
//            if (n <= 2) {
//                return 0;
//            }
//            LinkedList<Integer> linkedList1 = new LinkedList<>();
//            LinkedList<Integer> linkedList2 = new LinkedList<>();
//            for (int i = 2; i < n; i++) {
//                linkedList1.add(i);
//            }
//            for (int i = 3; i)
//        }
//    }


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
