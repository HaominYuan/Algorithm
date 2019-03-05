package leetcode;

public class SortList {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(1);
        ListNode listNode4 = new ListNode(3);
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
        System.out.println(new Solution().sortList(listNode1));
    }

    static class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null) {
                return null;
            }

            ListNode p = head;
            int count = 1;
            while ((p = p.next) != null) {
                count = count + 1;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            func(dummy, count);
            return dummy.next;
        }

        void func(ListNode dummy, int length) {
            if (length == 1) {
                dummy.next.next = null;
                return;
            }
            int length1 = length / 2;
            int length2 = length - length1;

            ListNode dummy1 = dummy;
            ListNode p = dummy1.next;
            for (int i = 0; i < length1; i++) {
                p = p.next;
            }

            ListNode dummy2 = new ListNode(0);
            dummy2.next = p;
            for (int i = 0; i < length2; i++) {
                p = p.next;
            }

            func(dummy1, length1);
            func(dummy2, length2);

            p = dummy;
            dummy1 = dummy1.next;
            dummy2 = dummy2.next;
            while (dummy1 != null && dummy2 != null) {
                if (dummy1.val < dummy2.val) {
                    p.next = dummy1;
                    dummy1 = dummy1.next;
                } else {
                    p.next = dummy2;
                    dummy2 = dummy2.next;
                }
                p = p.next;
            }

            p.next = dummy1 == null ? dummy2 : dummy1;
        }
    }
}
