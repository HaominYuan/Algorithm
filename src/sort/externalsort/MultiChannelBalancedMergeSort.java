package sort.externalsort;

import java.io.*;

public class MultiChannelBalancedMergeSort {
    private static int k;
    private static BufferedReader[] bufferedReaders;
    private static int[] loserTree;
    private static double[] block;

    public static void multiChannelBalancedMergeSort(String path, int blockNum) throws IOException {
        k = blockNum;
        bufferedReaders = new BufferedReader[k];
        loserTree = new int[k];
        block = new double[k + 1];
        for (int i = 0; i < k; i++) {
            bufferedReaders[i] = new BufferedReader(new FileReader(path + File.separator + i));
        }

        for (int i = 0; i < k; i++) {
            input(i);
        }

        createLoserTree();

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + "MultiChannelBalancedMergeSort"));

        while (block[loserTree[0]] != Double.MAX_VALUE) {
            bufferedWriter.write(String.valueOf(block[loserTree[0]]));
            bufferedWriter.newLine();
            input(loserTree[0]);
            adjust(loserTree[0]);
        }
        bufferedWriter.close();

        for (BufferedReader bufferedReader : bufferedReaders) {
            bufferedReader.close();
        }
    }

    private static void adjust(int s) {
        // 这里加k是为了让输入的节点变成叶子
        int t = (s + k) / 2;
        int swap;
        while (t > 0) {
            // 如果补充的值大于父节点意味着需要更换胜者
            // 否则胜者则继续想向父亲的父亲比较
            if (block[s] > block[loserTree[t]]) {
                swap = s;
                s = loserTree[t];
                loserTree[t] = swap;
            }
            // 不断的指向父亲
            t = t / 2;
        }
        loserTree[0] = s;
    }

    private static void input(int i) throws IOException {
        String line = null;
        if ((line = bufferedReaders[i].readLine()) != null) {
            block[i] = Double.parseDouble(line);
        } else {
            block[i] = Double.MAX_VALUE;
        }
    }

    private static void createLoserTree() {
        block[k] = Double.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            loserTree[i] = k;
        }
        for (int i = k - 1; i >= 0; i--) {
            adjust(i);
        }
    }
}
