package recommendsystem;

import java.io.IOException;
import java.util.ArrayList;

public class MemoryBasedCF {
    private static final int K = 100;
    public static void main(String[] args) throws IOException {
//        System.out.println(new CalScore() {
//            @Override
//            public void predict() {
//                for (int[] aX : X) {
//                    int user = aX[0];
//                    int item = aX[1];
//                    double[] temp1 = null;
//                    double[] temp2 = null;
//                    ArrayList<double[]> similarity = new ArrayList<>();
//                    temp1 = getRowArray(user);
//                    for (int i = 0; i < mat.length; i++) {
//                        if (i == user) {
//                            continue;
//                        }
//                        temp2 = getRowArray(i);
//
//                        similarity.add(new double[]{i, calSimilarity(temp1, temp2)});
//                    }
//
////                    实现了comparator接口
//                    similarity.sort1((o1, o2) -> {
//                        Double temp11 = o1[1];
//                        Double temp21 = o2[1];
//                        return -temp11.compareTo(temp21);
//                    });
//
//                    double score = 0;
//                    double count = 0;
//                    for (int i = 0; i < K; i++) {
//                        if (mat[i][item] != 0) {
//                            count = count + similarity.get(i)[1];
//                            score = score + similarity.get(i)[1] * (mat[i][item] - userAverage.get(i));
//                        }
//                    }
//                    if (count != 0) {
//                        score = userAverage.get(user) + score / count;
//                    } else {
//                        score = userAverage.get(user);
//                    }
//                    if (score > 5) {
//                        preY.add(5.);
//                    } else if (score < 1) {
//                        preY.add(1.);
//                    } else {
//                        preY.add(score);
//                    }
//                }
//            }
//        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));




        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : X) {
                    int user = aX[0];
                    int item = aX[1];
                    double[] temp1 = null;
                    double[] temp2 = null;
                    ArrayList<double[]> similarity = new ArrayList<>();
                    temp1 = getColumnArray(item);
                    for (int j = 0; j < mat[user].length; j++) {
                        if (j == item) {
                            continue;
                        }
                        temp2 = getColumnArray(j);
                        similarity.add(new double[]{j, calSimilarity(temp1, temp2)});
                    }

                    //                    实现了comparator接口
                    similarity.sort((o1, o2) -> {
                        Double temp11 = o1[1];
                        Double temp21 = o2[1];
                        return -temp11.compareTo(temp21);
                    });

                    double score = 0;
                    double count = 0;
                    for (int i = 0; i < K; i++) {
                        if (mat[i][item] != 0) {
                            count = count + similarity.get(i)[1];
                            score = score + similarity.get(i)[1] * mat[i][item];
                        }
                    }
                    if (count == 0) {
                        score = 0;
                    } else {
                        score = score / count;
                    }
                    if (score > 5) {
                        score = 5;
                    } else if (score < 1) {
                        score = 1;
                    }
                    preY.add(score);
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));
    }



}
