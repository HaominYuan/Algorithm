package leetcode;

public class PartitionList {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(2);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        System.out.println(new Solution().partition(listNode1, 3));

    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode dummy1 = new ListNode(0);
            ListNode p1 = dummy1;
            ListNode dummy2 = new ListNode(0);
            ListNode p2 = dummy2;
            while (head != null) {
                if (head.val < x) {
                    p1.next = head;
                    p1 = p1.next;
                } else {
                    p2.next = head;
                    p2 = p2.next;
                }
                head = head.next;
            }
            p2.next = null;
            p1.next = dummy2.next;
            return dummy1.next;
        }
    }
}
