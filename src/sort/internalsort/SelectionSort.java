package sort.internalsort;

public class SelectionSort {
    static void selectionSort(double[] array) {
        double temp;
        for (int i = 0; i < array.length - 1; i++) {
            double min = array[i];
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    min = array[j];
                    index = j;
                }
            }
            temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}
