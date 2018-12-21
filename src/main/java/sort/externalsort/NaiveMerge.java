package sort.externalsort;

import java.io.*;

public class NaiveMerge {
    public static void merge(String path, int blockNum) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + "NaiveMerge"));
        BufferedReader[] bufferedReaders = new BufferedReader[blockNum];
        for (int i = 0; i < bufferedReaders.length; i++) {
            bufferedReaders[i] = new BufferedReader(new FileReader(path + File.separator + i));
        }
        Double[] doubles = new Double[blockNum];
        for (int i = 0; i < doubles.length; i++) {
            String temp = bufferedReaders[i].readLine();
            if (temp != null) {
                doubles[i] = Double.parseDouble(temp);
            } else {
                doubles[i] = Double.MAX_VALUE;
            }
        }
        do {
            double min = Double.MAX_VALUE;
            int minI = 0;
            for (int i = 0; i < doubles.length; i++) {
                if (doubles[i] < min) {
                    min = doubles[i];
                    minI = i;
                }
            }
            if (min != Double.MAX_VALUE) {
                bufferedWriter.write(String.valueOf(min));
                bufferedWriter.newLine();
                String temp = bufferedReaders[minI].readLine();
                if (temp != null) {
                    doubles[minI] = Double.parseDouble(temp);
                } else {
                    doubles[minI] = Double.MAX_VALUE;
                }
            } else {
                break;
            }
        } while (true);
        bufferedWriter.close();
        for (BufferedReader bufferedReader : bufferedReaders) {
            bufferedReader.close();
        }
    }
}
