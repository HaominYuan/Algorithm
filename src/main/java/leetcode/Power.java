package leetcode;

public class Power {
    private boolean g_InvalidInput = false;


    public static void main(String[] args) {
        Power tmp = new Power();
        System.out.println(tmp.power(2.0, 3));
    }

    private double power(double base, int exponent) {

        if (base == 0 && exponent < 0) {
            g_InvalidInput = true;
            return 0.0;
        }

        int absExponent = Math.abs(exponent);
        double result = 1.0;
        while (absExponent != 0) {
            if ((absExponent & 1) == 1) {
                result = result * base;
            }
            base = base * base;
            absExponent = absExponent >> 1;
        }


        if (exponent < 0) {
            result = 1 / result;
        }
        return result;
    }


}
