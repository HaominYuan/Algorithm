package leetcode;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MySolution().sortArrayByParity(new int[]{0, 2})));
    }

    static class Solution {
        public int[] sortArrayByParity(int[] A) {
            int p1 = 0, p2 = A.length - 1;
            while (p1 < p2) {
                while (p1 < p2 && (A[p1] & 1) == 0) {
                    p1 = p1 + 1;
                }
                while (p1 < p2 && (A[p2] & 1) != 0) {
                    p2 = p2 - 1;
                }
                int tmp = A[p1];
                A[p1] = A[p2];
                A[p2] = tmp;
            }
            int tmp = A[p1];
            A[p1] = A[p2];
            A[p2] = tmp;
            return A;
        }
    }

    static
    class MySolution {
        public int[] sortArrayByParity(int[] A) {
            int index = 0;
            for (int i = 0; i < A.length; i++) {
                if ((A[i] & 1) == 0) {
                    int tmp = A[i];
                    A[i] = A[index];
                    A[index++] = tmp;
                }
            }
            return A;
        }
    }

}
