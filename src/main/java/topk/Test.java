package topk;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++) {
            data[i] = (int) (Math.random() * 1000);
        }
        System.out.println(Arrays.toString(data));
        MinHeap heap = new MinHeap(3);
        for (int aData : data) {
            heap.addNumber(aData);
        }
        System.out.println(heap);
    }
}
