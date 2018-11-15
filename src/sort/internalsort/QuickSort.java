package sort.internalsort;

public class QuickSort {
    static void quickSort(double[] array) {
        quickDivideSortFunction(array, 0, array.length - 1);
    }

    private static void quickDivideSortFunction(double[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int divide = partition(array, begin, end);
        quickDivideSortFunction(array, begin, divide - 1);
        quickDivideSortFunction(array, divide + 1, end);
    }

    private static int partition(double[] array, int begin, int end) {
        int divide = begin;
        double temp;
        double axis = array[end];
        for (int i = begin; i < end; i++) {
            if (array[i] < axis) {
                temp = array[i];
                array[i] = array[divide];
                array[divide] = temp;
                divide = divide + 1;
            }
        }
        array[end] = array[divide];
        array[divide] = axis;
        return divide;
    }
}
