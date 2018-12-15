package leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class SellingVegetables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[15][10];
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        int[][] x = new int[4][4];
        int[] high = new int[4];
        Arrays.fill(high, -1);
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                x[i][j] = scanner.nextInt();
                if (x[i][j] == 1) {
                    high[j] = i;
                }
            }
        }
        int n = scanner.nextInt();
        int[] meet = new int[4];
        Arrays.fill(meet, 15);
        for (int j = 0; j < 4; j++) {
            if (high[j] != -1) {
                for (int i = 0; i < 15; i++) {
                    if (map[i][j + n - 1] == 1) {
                        meet[j] = i;
                        break;
                    }
                }
            }
        }
        int minJ = -1;
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 4; j++) {
            if (min > meet[j] - high[j]) {
                min = meet[j] - high[j];
                minJ = j;
            }
        }

    }
}
