package sort.internalsort;

import java.util.Stack;

public class QuickSort {
    static void quickSort(double[] array) {
        quickDivideSortFunctionR(array, 0, array.length - 1);
    }

    private static void quickDivideSortFunctionR(double[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int divide = partition(array, begin, end);
        quickDivideSortFunctionR(array, begin, divide - 1);
        quickDivideSortFunctionR(array, divide + 1, end);
    }

    private static void func(double[] nums, int begin, int end) {
        Stack<Integer[]> stack = new Stack<>();
        Integer[] cur = new Integer[]{begin, 0, end};
        while (cur[0] < cur[2] || !stack.isEmpty()) {
            if (cur[0] < cur[2]) {
                int partition = partition(nums, cur[0], cur[2]);
                stack.add(new Integer[]{cur[0], partition, cur[2]});
                cur = new Integer[]{cur[0], 0, partition - 1};
            } else {
                cur = stack.pop();
                cur = new Integer[]{cur[1] + 1, 0, cur[2]};
            }
        }
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
