package leetcode.ccf;

import java.util.Scanner;

public class GroceryShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int[] result = new int[array.length];
        for (int i = 1; i < array.length - 1; i++) {
            result[i] = (array[i - 1] + array[i] + array[i + 1]) / 3;
        }
        result[0] = (array[0] + array[1]) / 2;
        result[array.length - 1] = (array[array.length - 1] + array[array.length - 2]) / 2;

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
