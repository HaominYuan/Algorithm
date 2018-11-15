package lcs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static lcs.LCS.calMaximumNum;
import static lcs.LCS.calSimilarity;
import static lcs.LCS.findLCSString;

public class CodeCheck {
    private double threshold;
    private String file1, file2;
    private Double[][] similarityMatrix;
    private Boolean[][] matrix;
    private int maxNumber;

    CodeCheck(String file1, String file2) {
        threshold = 0.88;
        this.file1 = file1;
        this.file2 = file2;
    }

    CodeCheck(String file1, String file2, double threshold) {
        this(file1, file2);
        this.threshold = threshold;
    }

    void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    double getThreshold() {
        return threshold;
    }

    void cal() {
        List<String> list1 = readFile(file1);
        List<String> list2 = readFile(file2);
        similarityMatrix = calSimilarityMatrix(list1, list2);
        matrix = classify(similarityMatrix);
        maxNumber = calMaximumNum(matrix);
    }

    private List<String> readFile(String path) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Double[][] calSimilarityMatrix(List<String> list1, List<String> list2) {
        Double[][] matrix = new Double[list1.size()][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Double[list2.size()];
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = calSimilarity(list1.get(i), list2.get(j));
                System.out.println(findLCSString(list1.get(i), list2.get(j)));
            }
        }
        return matrix;
    }

    private Boolean[][] classify(Double[][] similarityMatrix) {
        Boolean[][] matrix = new Boolean[similarityMatrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new Boolean[similarityMatrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = similarityMatrix[i][j] > threshold;
            }
        }
        return matrix;
    }

    private String displayMatrix(Object[][] objects) {
        StringBuilder s = new StringBuilder();
        for (Object[] object : objects) {
            for (Object anObject : object) {
                s.append(anObject).append(" ");
            }
            s.append('\n');
        }
        return s.toString();
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Threshold：").append(threshold).append('\n');
        s.append("file1：").append(file1).append('\n');
        s.append("file2：").append(file2).append('\n');
        s.append("矩阵S：").append('\n');
        s.append(displayMatrix(similarityMatrix));
        s.append("矩阵D：").append('\n');
        s.append(displayMatrix(matrix));
        s.append("最多重复行的个数为：").append(maxNumber).append('\n');
        s.append("重复率为：").append((double) maxNumber / Math.min(similarityMatrix.length, similarityMatrix[0].length))
                .append('\n');
        return s.toString();
    }
}
