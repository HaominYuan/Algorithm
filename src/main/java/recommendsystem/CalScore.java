package recommendsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public abstract class CalScore {
    ArrayList<Double> userAverage = new ArrayList<>();
    ArrayList<Double> userBasis = new ArrayList<>();
    ArrayList<Double> itemAverage = new ArrayList<>();
    ArrayList<Double> itemBasis = new ArrayList<>();
    double average;
    ArrayList<int[]> X = new ArrayList<>();
    ArrayList<Double> preY = new ArrayList<>();
    ArrayList<Integer> actY = new ArrayList<>();
    int[][] mat;

    final double process(String trainPath, String testPath) throws IOException {
        loadTrainData(trainPath);
        loadTestData(testPath);
        predict();
        return score();
    }

    private void loadTestData(String testPath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(testPath));
        String temp = null;
        String[] splits = null;
        while ((temp = bufferedReader.readLine()) != null) {
            splits = temp.split("\t");
            X.add(new int[]{Integer.parseInt(splits[0]) - 1, Integer.parseInt(splits[1]) - 1});
            actY.add(Integer.parseInt(splits[2]));
        }
        bufferedReader.close();
    }

    private void loadTrainData(String trainPath) throws IOException {
        mat = new int[943][];
        for (int i = 0; i < mat.length; i++) {
            mat[i] = new int[1682];
        }


        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/recommendsystem/u2.base"));
        String temp = null;
        String[] splits;
        while ((temp = bufferedReader.readLine()) != null) {
            splits = temp.split("\t");
            mat[Integer.parseInt(splits[0]) - 1][Integer.parseInt(splits[1]) - 1] = Integer.parseInt(splits[2]);
        }
        bufferedReader.close();


        average = 0;
        int count = 0;


        for (int i = 0; i < mat.length; i++) {
            count = 0;
            userAverage.add(0.0);
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    count = count + 1;
                    userAverage.set(i, userAverage.get(i) + mat[i][j]);
                }
            }
            userAverage.set(i, userAverage.get(i) / count);

        }


        for (int j = 0; j < mat[0].length; j++) {
            count = 0;
            itemAverage.add(0.0);
            for (int[] aMat : mat) {
                if (aMat[j] != 0) {
                    count = count + 1;
                    itemAverage.set(j, itemAverage.get(j) + aMat[j]);
                }
            }
            itemAverage.set(j, itemAverage.get(j) / count);
        }

        for (int i = 0; i < mat.length; i++) {
            count = 0;
            userBasis.add(0.0);
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    count = count + 1;
                    userBasis.set(i, userBasis.get(i) + mat[i][j] - itemAverage.get(j));
                }
            }
            userBasis.set(i, userBasis.get(i) / count);
        }


        for (int j = 0; j < mat[0].length; j++) {
            count = 0;
            itemBasis.add(0.0);
            for (int i = 0; i < mat.length; i++) {
                if (mat[i][j] != 0) {
                    count = count + 1;
                    itemBasis.set(j, itemBasis.get(j) + mat[i][j] - userAverage.get(i));
                }
            }
            itemBasis.set(j, itemBasis.get(j) / count);
        }


        average = 0;
        count = 0;
        for (int[] aMat : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                if (aMat[j] != 0) {
                    count = count + 1;
                    average = average + aMat[j];
                }
            }
        }
        average = average / count;
    }

    public abstract void predict();

    private double score() {
        double sum = 0;
        int count = 0;
        for (int i = 0; i < this.preY.size(); i++) {
            if (!Double.isNaN(this.preY.get(i))) {
                count = count + 1;
                sum = sum + Math.abs(this.preY.get(i) - this.actY.get(i));
            }
        }
        return sum / count;
    }


    double[] getRowArray(int user) {
        double[] temp = new double[mat[user].length];
        for (int j = 0; j < temp.length; j++) {
            if (mat[user][j] != 0) {
                temp[j] = mat[user][j] - userAverage.get(user);
            }
        }
        return temp;
    }


    double[] getColumnArray(int item) {
        double[] temp = new double[mat.length];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = mat[i][item];
        }
        return temp;
    }

    double calSimilarity(double[] vector1, double[] vector2) {
        double score = 0;
        double s1 = 0;
        double s2 = 0;
        for (int i = 0; i < vector1.length; i++) {
            if (vector1[i] != 0 && vector2[i] != 0) {
                score = score + vector1[i] * vector2[i];
                s1 = s1 + Math.pow(vector1[i], 2);
                s2 = s2 + Math.pow(vector2[i], 2);
            }
        }
        if (s1 == 0 || s2 == 0) {
            score = 0;
        } else {
            score = score / Math.sqrt(s1) / Math.sqrt(s2);
        }
        return score;
    }
}
