package sort.internalsort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        Double[] array = new Double[5];

        for (int i = 0; i < 5; i++) {
            array[i] = Math.random();
//            array[i] = i;
        }
        System.out.println(Arrays.toString(array));

//        sort(array);
        sort(array, 1, 3);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(Double[] array, int begin, int end) {
        for (int i = (end - begin + 1) / 2 - 1; i >= 0; i--) {
            adjust(array, begin, i, end);
        }
        System.out.println(Arrays.toString(array));

        for (int i = (end - begin + 1) - 1; i > 0; i--) {
            swap(array, begin, i);
            adjust(array, begin, 0, i - 1);
        }
    }

    public static void sort(Double[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void swap(Double[] array, int offset, int i) {
        double temp = array[offset];
        array[offset] = array[i + offset];
        array[i + offset] = temp;
    }

    public static void adjust(Double[] array, int offset, int begin, int end) {
        double temp = array[offset + begin];
        for (int i = begin * 2 + 1; i <= end; i = i * 2 + 1) {
            if (offset + i + 1 <= end && array[offset + i] > array[offset + i + 1]) {
                i = i + 1;
            }

            if (array[offset + i] < temp) {
                array[offset + begin] = array[offset + i];
                begin = i;
            } else {
                break;
            }
        }
        array[offset + begin] = temp;
    }
}
