package leetcode;

public class RotateList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;
        System.out.println(new MySolution().rotateRight(listNode1, 0));
    }

    static class MySolution {
        public ListNode rotateRight(ListNode head, int k) {

            if (head == null) {
                return null;
            }
            if (k == 0) {
                return head;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode last = dummy.next;
            int length = 1;
            while (last.next != null) {
                if (k < length + 1) {
                    pre = pre.next;
                }

                last = last.next;
                length = length + 1;
            }

            last.next = dummy.next;

            if (k < length) {
                ListNode temp = pre.next;
                pre.next = null;
                return temp;
            }


            k = k % length;
            k = length - k;
            last = dummy.next;
            pre = dummy;
            for (int i = 0; i < k; i++) {
                pre = pre.next;
                last = last.next;
            }
            pre.next = null;
            return last;
        }
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            int n = 1;
            ListNode cur = head;
            while (cur.next != null) {
                n = n + 1;
                cur = cur.next;
            }
            cur.next = head;
            int m = n - k % n;
            for (int i = 0; i < m; i++) {
                cur = cur.next;
            }
            ListNode temp = cur.next;
            cur.next = null;
            return temp;
        }
    }
}
