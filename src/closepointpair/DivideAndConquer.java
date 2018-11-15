package closepointpair;

public class DivideAndConquer {
    private static int k = 3;

    public static void setK(int k) {
        DivideAndConquer.k = k;
    }

    public static double func(Double[][] points) {
        sort(points, 0);
        return func(points, 0, points.length - 1);
    }

    private static double func(Double[][] pointPair, int begin, int end) {
        if (end - begin <= k) {
            return BruteForce.func(pointPair, begin, end);
        }else {
            int mid = (begin + end) / 2;
            double d1 = func(pointPair, begin, mid);
            double d2 = func(pointPair, mid + 1, end);
            double min = Math.min(d1, d2);


            int left = mid - 1;
            while (true) {
                if (left >= begin && pointPair[mid][0] - pointPair[left][0] <= min) {
                    left = left - 1;
                } else {
                    left = left + 1;
                    break;
                }
            }

            int right = mid + 1;
            while (true) {
                if (right <= end && pointPair[right][0] - pointPair[mid][0] <= min) {
                    right = right + 1;
                } else {
                    right = right - 1;
                    break;
                }
            }

            Double[][] copy = new Double[right - left + 1][];
            for (int i = 0; i <= right - left; i++) {
                copy[i] = new Double[2];
                System.arraycopy(pointPair[left + i], 0, copy[i], 0, 2);
            }
            quickSort(copy, 0, right - left, 1);


            for (int i = 0; i < copy.length; i++) {
                for (int j = i + 1; j < copy.length && (copy[j][1] - copy[i][1]) < min; j++) {
                    double distance = Math.pow(Math.pow(copy[j][0] - copy[i][0], 2) +
                            Math.pow(copy[j][1] - copy[i][1], 2), 0.5);
                    if (distance < min) {
                        min = distance;
                    }
                }
            }
            return min;
        }

    }

    static void sort(Double[][] pairPoint, int index) {
        quickSort(pairPoint, 0, pairPoint.length - 1, index);
    }

    private static void quickSort(Double[][] array, int begin, int end, int index) {
        if (begin >= end) {
            return;
        }

        int divide = partition(array, begin, end, index);
        quickSort(array, begin, divide - 1, index);
        quickSort(array, divide + 1, end, index);
    }

    private static int partition(Double[][] array, int begin, int end, int index) {
        int divide = begin;
        Double[] temp = new Double[2];
        Double[] axis = new Double[2];
        axis[0] = array[end][0];
        axis[1] = array[end][1];
        for (int i = begin; i < end; i++) {
            if (array[i][index] <=axis[index]) {
                temp[0] = array[i][0];
                temp[1] = array[i][1];
                array[i][0] = array[divide][0];
                array[i][1] = array[divide][1];
                array[divide][0] = temp[0];
                array[divide][1] = temp[1];
                divide = divide + 1;
            }
        }
        array[end][0] = array[divide][0];
        array[end][1] = array[divide][1];
        array[divide][0] = axis[0];
        array[divide][1] = axis[1];
        return divide;
    }
}