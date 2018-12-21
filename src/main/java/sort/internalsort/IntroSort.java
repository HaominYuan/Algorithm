package sort.internalsort;

public class IntroSort {
    private static int size_threshold = 128;

    public static void setSize_threshold(int size_threshold) {
        IntroSort.size_threshold = size_threshold;
    }

    public static void sort(double[] array) {
        introSortLoop(array, 0, array.length, 2 * floor_lg(array.length));
    }

    public static void sort(double[] array, int begin, int end) {
        if (begin < end) {
            introSortLoop(array, begin, end, 2 * floor_lg(end - begin));
        }
    }

    private static void introSortLoop(double[] array, int lo, int hi, int depth_limit) {
        while (hi - lo > size_threshold) {
            if (depth_limit == 0) {
                heapsort(array, lo, hi);
                return;
            }
            depth_limit = depth_limit - 1;
            int p = partition(array, lo, hi, medianOf3(array, lo, lo + ((hi - lo) / 2) + 1, hi - 1));
            introSortLoop(array, p, hi, depth_limit);
            hi = p;
        }
        insertionSort(array, lo, hi);
    }

    private static int partition(double[] array, int lo, int hi, double x) {
        int i = lo, j = hi;
        while (true) {

            while (array[i] < x) i++;
            j = j - 1;
            while (x < array[j]) j = j - 1;
            if (!(i < j))
                return i;
            exchange(array, i, j);
            i++;
        }
    }

    private static double medianOf3(double[] array, int lo, int mid, int hi) {
        if (array[mid] < array[lo]) {
            if (array[hi] < array[mid])
                return array[mid];
            else {
                if (array[hi] < array[lo])
                    return array[hi];
                else
                    return array[lo];
            }
        } else {
            if (array[hi] < array[mid]) {
                if (array[hi] < array[lo])
                    return array[lo];
                else
                    return array[hi];
            } else
                return array[mid];
        }
    }

    private static void heapsort(double[] array, int lo, int hi) {
        int n = hi - lo;
        for (int i = n / 2; i >= 1; i = i - 1) {
            downHeap(array, i, n, lo);
        }
        for (int i = n; i > 1; i = i - 1) {
            exchange(array, lo, lo + i - 1);
            downHeap(array, 1, i - 1, lo);
        }
    }

    private static void downHeap(double[] array, int i, int n, int lo) {
        double d = array[lo + i - 1];
        int child;
        while (i <= n / 2) {
            child = 2 * i;
            if (child < n && array[lo + child - 1] < array[lo + child]) {
                child++;
            }
            if (d >= array[lo + child - 1]) {
                break;
            }
            array[lo + i - 1] = array[lo + child - 1];
            i = child;
        }
        array[lo + i - 1] = d;
    }

    private static void insertionSort(double[] array, int begin, int hi) {
        int i, j;
        double t;
        for (i = begin; i < hi; i++) {
            j = i;
            t = array[i];
            while (j != begin && t < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = t;
        }
    }

    private static void exchange(double[] array, int i, int j) {
        double t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // 返回理论上最佳的深度界限
    private static int floor_lg(int a) {
        return (int) (Math.floor(Math.log(a) / Math.log(2)));
    }


}