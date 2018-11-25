package leetcode;

import java.util.HashSet;

public class UglyNumberII {
    public static void main(String[] args) {
        System.out.println(new NaiveSolution().nthUglyNumber(10));
    }

    static class NaiveSolution {

        public int nthUglyNumber(int n) {
            int[] arr = new int[n];
            arr[0] = 1;
            int n2 = 0, n3 = 0, n5 = 0;
            int i = 1;
            while (i < n) {
                int min = Math.min(arr[n2] * 2, Math.min(arr[n3] * 3, arr[n5] * 5));
                if (min >= arr[n2] * 2) {
                    n2++;
                }
                if (min >= arr[n3] * 3) {
                    n3++;
                }
                if (min >= arr[n5] * 5) {
                    n5++;
                }
                arr[i] = min;
                i++;
            }
            return arr[n - 1];
        }
    }

//    static class Solution {
//        public int nthUglyNumber(int n) {
//            if (n == 1) {
//                return 1;
//            }
//
//        }
//    }

}
