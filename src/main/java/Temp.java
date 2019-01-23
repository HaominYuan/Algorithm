public class Temp {
    public static void main(String[] args) {
        double[] nums = new double[7];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.random();
        }
        heapSort(nums);
        for (double num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();
    }


    private static void heapSort(double[] nums) {
        // 循环建立初始堆
        for (int i = nums.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(nums, i, nums.length);
        }

        // 进行n-1次循环，完成排序
        for (int i = nums.length - 1; i > 0; i--) {

            // 最后一个元素和第一元素进行交换
            double temp = nums[i];
            nums[i] = nums[0];
            nums[0] = temp;

            // 筛选 R[0] 结点，得到i-1个结点的堆
            HeapAdjust(nums, 0, i);
            System.out.format("第 %d 趟: \t", nums.length - i);

            for (double num : nums) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }

    }

    private static void HeapAdjust(double[] array, int parent, int length) {
        double temp = array[parent];
        int child = parent * 2 + 1;
        while (child < length) {

            if (child + 1 < length && array[child] < array[child + 1]) {
                child = child + 1;
            }

            if (temp >= array[child]) {
                break;
            }

            array[parent] = array[child];
            parent = child;
            child = child * 2 + 1;
        }
        array[parent] = temp;

    }

}
