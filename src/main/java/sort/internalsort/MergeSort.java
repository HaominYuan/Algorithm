package sort.internalsort;

public class MergeSort {
    public static void mergeSort(double[] array) {
        mergeDivideSortFunction(array, 0, array.length - 1);
    }

    private static void mergeDivideSortFunction(double[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        mergeDivideSortFunction(array, begin, mid);
        mergeDivideSortFunction(array, mid + 1, end);
        mergeFunction(array, begin, mid, end);
    }

    private static void mergeFunction(double[] array, int begin, int mid, int end) {
        double[] tmp1 = new double[mid - begin + 2];
        double[] tmp2 = new double[end - mid + 1];
        System.arraycopy(array, begin, tmp1, 0, mid - begin + 1);
        System.arraycopy(array, mid + 1, tmp2, 0, end - mid);
        tmp1[mid - begin + 1] = Double.MAX_VALUE;
        tmp2[end - mid] = Double.MAX_VALUE;
        for (int k = 0, i = 0, j = 0; k < end - begin + 1; k++) {
            if (tmp1[i] < tmp2[j]) {
                array[begin + k] = tmp1[i++];
            } else {
                array[begin + k] = tmp2[j++];
            }
        }
    }
}
