package leetcode;

public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(new Solution().lemonadeChange(new int[]{10}));
    }

    static class Solution {
        public boolean lemonadeChange(int[] bills) {
            int five = 0;
            int ten = 0;
            for (int bill : bills) {
                switch (bill) {
                    case 5:
                        five = five + 1;
                        break;
                    case 10:
                        five = five - 1;
                        if (five < 0) {
                            return false;
                        }
                        ten = ten + 1;
                        break;
                    case 20:
                        if (ten != 0) {
                            ten = ten - 1;
                            five = five - 1;
                        } else {
                            five = five - 3;
                        }
                }
                if (five < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
