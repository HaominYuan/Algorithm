package recommendsystem;

import java.io.*;

public class AverageFilling {
    public static void main(String[] args) throws IOException {
        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : this.X) {
                    this.preY.add(this.userAverage.get(aX[0]));
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));

        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : this.X) {
                    this.preY.add(this.itemAverage.get(aX[1]));
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));


        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : this.X) {
                    this.preY.add(1. / 2 * this.userAverage.get(aX[0]) + 1. / 2 * this.itemAverage.get(aX[1]));
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));

        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : this.X) {
                    this.preY.add(this.userBasis.get(aX[0]) + this.itemAverage.get(aX[1]));
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));

        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : this.X) {
                    this.preY.add(this.userAverage.get(aX[0]) + this.itemBasis.get(aX[1]));
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));

        System.out.println(new CalScore() {
            @Override
            public void predict() {
                for (int[] aX : this.X) {
                    this.preY.add(this.average + this.userBasis.get(aX[0]) + this.itemBasis.get(aX[1]));
                }
            }
        }.process("src/recommendsystem/u2.base", "src/recommendsystem/u2.test1"));
    }
}
