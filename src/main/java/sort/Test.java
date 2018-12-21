package sort;

import sort.externalsort.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        String path = "/Users/yuanhaomin/Desktop/sort";
        double testTime = 100;

        double sum = 0;
        double begin = System.nanoTime();
        for (int i = 0; i < testTime; i++) {
            generalRandomNumber(path, 100000);
//            int block = LoserTreeReplaceSelection.loserTreeReplaceSelection(path, 60);
            int block = HeapReplaceSelection.heapReplaceSelection(path, 60);
            MultiChannelBalancedMergeSort.multiChannelBalancedMergeSort(path, block);
//            int block = NaiveInternalSort.naiveInternalSort(path, 60);
            NaiveMerge.merge(path, block);
        }
        double end = System.nanoTime();
        System.out.println((end - begin) / testTime);
//        CalTime calTime = new CalTime() {
//            @Override
//            public void sort(double[] array) throws IOException {
//                MergeSort.mergeSort(array);
//            }
//        };
//        double[] array = new double[50000];
//        System.out.println(calTime.process(array));
//
    }

    private static void generalRandomNumber(String path, int n) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + "-1"));
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(String.valueOf(Math.random()));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
