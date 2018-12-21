package csp;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] map = new int[2][];
        int[][] map2 = new int[2][];
        for (int i = 0; i < map.length; i++) {
            map[i] = new int[2];
            map2[i] = new int[2];
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = i * 2 + j;
                map2[i][j] = i * 2 + j;
            }
        }
        System.out.println(Arrays.hashCode(map));
        map[0][0] = 100;
        System.out.println(Arrays.hashCode(map));
        System.out.println(Arrays.hashCode(map2));

        System.out.println(Math.pow(5, 32));
    }
}
