package sort.externalsort;

import sort.internalsort.IntroSort;

import java.io.*;

public class NaiveInternalSort {
    public static int naiveInternalSort(String path, int workSpaceSize) throws IOException {
        double[] array = new double[workSpaceSize];
        String temp = null;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path + File.separator + "-1"));
        int i = 0, j = 0;
        while ((temp = bufferedReader.readLine()) != null) {
            array[i++] = Double.parseDouble(temp);
            if (i == workSpaceSize) {
                IntroSort.sort(array);
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + j++));
                for (int k = 0; k < i; k++) {
                    bufferedWriter.write(String.valueOf(array[k]));
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                i = 0;
            }
        }
        IntroSort.sort(array, 0, i);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + j++));
        for (int k = 0; k < i; k++) {
            bufferedWriter.write(String.valueOf(array[k]));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        return j;
    }
}
