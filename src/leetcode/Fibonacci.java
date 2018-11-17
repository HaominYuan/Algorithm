package leetcode;

public class Fibonacci {
    public static void main(String[] args) {

        double time1 = System.currentTimeMillis();
        System.out.println(func(2000));
        double time2 = System.currentTimeMillis();
        System.out.println(new Solution().func(2000));
        double time3 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println(time3 - time2);

//        if (new Solution().func(90) == func(90)) {
//            System.out.println("true");
//        }
    }

    static double func(int n) {
        double tmp1 = 0, tmp2 = 1, result = 0;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        for (int i = 2; i <= n; i++) {
            result = tmp1 + tmp2;
            tmp1 = tmp2;
            tmp2 = result;
        }
        return result;
    }

    static class Solution {
        double func(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            double[][] matrix = new double[2][];
            for (int i = 0; i < matrix.length; i++) {
                matrix[i] = new double[2];
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 1;
                }
            }
            matrix[1][1] = 0;
            double[][] ret = getMatrixPower(matrix, n - 2);
            return ret[0][0] + ret[1][0];
        }

        double[][] getMatrixPower(double[][] matrix, int n) {
            double[][] ret = new double[2][];
            double[][] tmp1 = new double[2][];
            double[][] tmp2 = new double[2][];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = new double[2];
                tmp1[i] = new double[2];
                tmp2[i] = new double[2];
                ret[i][i] = 1;
            }

            for (; n != 0; n >>= 1) {
                if ((n & 1) == 1) {
                    ret = matrixMul(ret, matrix, tmp1, tmp2);
                }
                matrix = matrixMul(matrix, matrix, tmp1, tmp2);
            }
            return ret;
        }

        double[][] matrixMul(double[][] l, double[][] r, double[][] tmp1, double[][] tmp2) {
            for (int i = 0; i < tmp1.length; i++) {
                System.arraycopy(l[i], 0, tmp1[i], 0, tmp1[i].length);
                System.arraycopy(r[i], 0, tmp2[i], 0, tmp2[i].length);
            }
            for (int i = 0; i < l.length; i++) {
                for (int j = 0; j < r[0].length; j++) {
                    l[i][j] = 0;
                    for (int k = 0; k < l.length; k++) {
                        l[i][j] += tmp1[i][k] * tmp2[k][j];
                    }
                }
            }
            return l;
        }


    }



}
