package topk;

import java.util.Arrays;

public class MinHeap {
    private int[] data;

    public MinHeap(int[] data) {
        this.data = data;
        buildHeap();
    }

    public MinHeap(int K) {
        data = new int[K];
        for (int i = 0; i < K; i++) {
            data[i] = Integer.MIN_VALUE;
        }
    }

    private void buildHeap() {
        for (int i = data.length / 2 - 1; i >= 0; i--) {
            adjust(i);
        }
    }

    private void adjust(int root) {
        int left = left(root);
        int right = right(root);

        int smallest = root;

        if (left < data.length && data[left] < data[smallest]) {
            smallest = left;
        }

        if (right < data.length && data[right] < data[smallest]) {
            smallest = right;
        }

        if (root == smallest) {
            return;
        }

        swap(root, smallest);
        adjust(smallest);
    }

    private void swap(int i, int j) {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    private int left(int i) {
        return (i << 1) + 1;
    }

    private int right(int i) {
        return (i + 1) << 1;
    }

    public boolean addNumber(int number) {
        if (number < data[0]) {
            return false;
        }
        data[0] = number;
        adjust(0);
        return true;
    }

    @Override
    public String toString() {
        return "MinHeap{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
