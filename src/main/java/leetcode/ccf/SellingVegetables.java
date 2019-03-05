package leetcode.ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SellingVegetables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer[]> list1 = new ArrayList<>();
        List<Integer[]> list2 = new ArrayList<>();
        int n = scanner.nextInt();
        func(list1, scanner, n);
        func(list2, scanner, n);
        int sum = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            Integer[] temp1 = list1.get(i);
            Integer[] temp2 = list2.get(j);
            int temp = Math.min(temp1[1], temp2[1]) - Math.max(temp1[0], temp2[0]);
            sum = sum + (temp > 0 ? temp : 0);
            if (temp1[1] < temp2[1]) {
                i = i + 1;
            } else {
                j = j + 1;
            }
        }
        System.out.println(sum);
    }

    private static void func(List<Integer[]> list, Scanner scanner, int n) {
        for (int i = 0; i < n; i++) {
            Integer[] temp = new Integer[2];
            temp[0] = scanner.nextInt();
            temp[1] = scanner.nextInt();
            list.add(temp);
        }
    }
}
