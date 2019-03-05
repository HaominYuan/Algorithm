package sort.externalsort;

import java.io.*;

public class LoserTreeReplaceSelection {
    private static BufferedReader bufferedReader;
    private static int[] loserTree;
    private static double[][] workArea;
    private static double minMax;
    private static int j;


    public static int loserTreeReplaceSelection(String path, int workSpaceSize) throws IOException {
        loserTree = new int[workSpaceSize];
        workArea = new double[workSpaceSize + 1][];
        minMax = Double.MIN_VALUE;


        bufferedReader = new BufferedReader(new FileReader(path + File.separator + "-1"));
        for (int i = 0; i < workArea.length; i++) {
            workArea[i] = new double[2];
        }

        for (int i = 0; i < workArea.length - 1; i++) {
            input(i);
        }
        createLoserTree();
        j = 0;
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + j));
        while (workArea[loserTree[0]][0] != Double.MAX_VALUE) {
            if (workArea[loserTree[0]][1] == j) {
                bufferedWriter.write(String.valueOf(workArea[loserTree[0]][0]));
                bufferedWriter.newLine();
            } else {
                bufferedWriter.close();
                bufferedWriter = new BufferedWriter(new FileWriter(path + File.separator + ++j));
                bufferedWriter.write(String.valueOf(workArea[loserTree[0]][0]));
                bufferedWriter.newLine();
            }


            minMax = workArea[loserTree[0]][0];
            input(loserTree[0]);
            adjust(loserTree[0]);
        }
        bufferedWriter.close();
        bufferedReader.close();
        return j + 1;
    }

    private static void createLoserTree() {
        workArea[workArea.length - 1][0] = Double.MIN_VALUE;
        workArea[workArea.length - 1][1] = -1;
        for (int i = 0; i < loserTree.length; i++) {
            loserTree[i] = loserTree.length;
        }
        for (int i = workArea.length - 2; i >= 0; i--) {
            adjust(i);

        }
    }

    private static void adjust(int s) {
        int t = (s + workArea.length - 1) / 2;
        int swap;
        while (t > 0) {
            if (workArea[s][1] > workArea[loserTree[t]][1] ||
                    workArea[s][1] == workArea[loserTree[t]][1] && workArea[s][0] > workArea[loserTree[t]][0]) {
                swap = s;
                s = loserTree[t];
                loserTree[t] = swap;
            }
            t = t / 2;
        }
        loserTree[0] = s;
    }

    private static void input(int i) throws IOException {
        String line;
        if ((line = bufferedReader.readLine()) != null) {
            double newNumber = Double.parseDouble(line);
            workArea[i][0] = Double.parseDouble(line);
            if (newNumber < minMax) {
                workArea[i][1] = j + 1;
            }
        } else {
            workArea[i][0] = Double.MAX_VALUE;
            workArea[i][1] = Double.MAX_VALUE;
        }
    }

}