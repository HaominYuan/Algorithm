package sort.internalsort;

public class InsertionSort {
    static void insertionSort(double[] array) {
        insertionSort(array, 0, array.length - 1);
    }

    private static void insertionSort(double[] array, int begin, int end) {
        double temp;
        int j;
        for (int i = begin + 1; i < end + 1; i++) {
            temp = array[i];
            for (j = i - 1; j >= 0; j--) {
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }


}
