package Exception.chainingexception;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入2个加数");
        int result;
        try {
            result = add();
            System.out.println("结果：" + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static List<Integer> getInputNumbers() {
        List<Integer> nums = new ArrayList<>();
        try (Scanner scanner = new Scanner(System.in)) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            nums.add(num1);
            nums.add(num2);
        }
        return nums;
    }


    private static int add() throws Exception {
        int result;
        try {
            List<Integer> nums = getInputNumbers();
            result = nums.get(0) + nums.get(1);
        } catch (InputMismatchException inputNumbers) {
            throw new Exception("计算失败", inputNumbers);
        }
        return result;
    }
}

