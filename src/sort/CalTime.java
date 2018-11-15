package sort;

import java.io.IOException;

public abstract class CalTime {
    public final double process(double[] array) throws IOException {
        double[] copy = new double[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        double start = System.nanoTime();
        this.sort(copy);
        double end = System.nanoTime();
        return end - start;
    }

    public abstract void sort(double[] array) throws IOException;
}
