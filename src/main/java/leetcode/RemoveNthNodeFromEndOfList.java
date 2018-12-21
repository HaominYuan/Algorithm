package leetcode;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
//        1->2->3->4->5 n = 2
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
//        leetcode.ListNode listNode3 = new leetcode.ListNode(3);
//        leetcode.ListNode listNode4 = new leetcode.ListNode(4);
//        leetcode.ListNode listNode5 = new leetcode.ListNode(5);
        listNode1.next = listNode2;
//        listNode2.calNext = listNode3;
//        listNode3.calNext = listNode4;
//        listNode4.calNext = listNode5;
        System.out.println(Solution.removeNthFromEnd(listNode1, 1));
    }

    static class Solution {
        static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode temp = new ListNode(0);
            temp.next = head;
            ListNode p = temp;
            ListNode pre;
            while (n >= 0) {
                n = n - 1;
                p = p.next;
            }
            pre = temp;
            while (p != null) {
                p = p.next;
                pre = pre.next;
            }
            pre.next = pre.next.next;
            return temp.next;
        }
    }

}
