package sort.internalsort;

public class BubbleSort {
    static void bubbleSort(double[] array) {
        double temp;
        int n = array.length;
        int newn;
        do {
            newn = -1;
            for (int i = 0; i < n - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    newn = i;
                }
            }
            n = newn;
        } while (n != -1);
    }

    static void naiveBubbleSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean flag = true;
            for (int j = array.length - 1; j > i; j--) {
                if (array[j] < array[j - 1]) {
                    double temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
