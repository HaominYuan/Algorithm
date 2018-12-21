package sort.externalsort;

import sort.internalsort.HeapSort;

import java.io.*;

public class HeapReplaceSelection {

    public static int heapReplaceSelection(String path, int workSpaceSize) throws IOException {

        Double[] doubles = new Double[workSpaceSize];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path + File.separator + "-1"));
        // 初始化数组
        for (int i = 0; i < doubles.length; i++) {
            String temp = bufferedReader.readLine();
            if (temp != null) {
                doubles[i] = Double.parseDouble(temp);
            } else {
                doubles[i] = Double.MAX_VALUE;
            }
        }

        // 将堆进行初始化

        for (int i = doubles.length / 2 - 1; i >= 0; i--) {
            HeapSort.adjust(doubles, 0, i, doubles.length - 1);
        }

        int count = 0;
        int length = doubles.length;
        Double minMax = Double.MIN_VALUE;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + count++));
        while (doubles[0] != Double.MAX_VALUE) {
            bufferedWriter.write(String.valueOf(doubles[0]));
            bufferedWriter.newLine();
            minMax = doubles[0];
            Double value = input(bufferedReader);
            if (value == Double.MAX_VALUE || value < minMax) {
                HeapSort.swap(doubles, 0, length - 1);
                doubles[length - 1] = value;
                length = length - 1;
            } else {
                doubles[0] = value;
            }
            if (length == 0) {
                bufferedWriter.close();
                bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + count++));
                length = doubles.length;
                for (int i = doubles.length / 2 - 1; i >= 0; i--) {
                    HeapSort.adjust(doubles, 0, i, doubles.length - 1);
                }
            } else {
                HeapSort.adjust(doubles, 0, 0, length - 1);
            }
        }
        bufferedWriter.close();
        bufferedReader.close();
        return count;
    }

    private static Double input(BufferedReader bufferedReader) throws IOException {
        String temp = bufferedReader.readLine();
        if (temp != null) {
            return Double.parseDouble(temp);
        } else {
            return Double.MAX_VALUE;
        }
    }
}
