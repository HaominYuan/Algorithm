package leetcode;

public class JosephCircle {
    public static void main(String[] args) {
        int m = 5, n = 2;
        System.out.println(new Solution().remainNumber(m, n));
    }

    static class NaiveSolution {
        int remainNumber(int m, int n) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            for (int i = 0; i < m; i++) {
                p.next = new ListNode(i + 1);
                p = p.next;
            }
            p.next = dummy.next;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    p = p.next;
                }
                p.next = p.next.next;
            }
            return p.val;
        }
    }

    static class Solution {
        int remainNumber(int m, int n) {
            int index = 0;
            for (int i = 2; i <= m; i++) {
                index = (index + n) % i;
            }
            return index + 1;
        }
    }


}
