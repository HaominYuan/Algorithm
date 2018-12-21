package leetcode;

public class SwapNodesInPairs {
    public static void main(String[] args) {
//        Given 1->2->3->4, you should return the lists as 2->1->4->3.
//        [0,7,2,6,6,8,0,3,4,5]
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        System.out.println(Solution.swapPairs(listNode1));
    }


    static class Solution {
        static ListNode swapPairs(ListNode head) {
            ListNode h1 = new ListNode(0);
            ListNode h2 = new ListNode(0);
            ListNode h3 = new ListNode(0);
            h1.next = h2;
            h2.next = h3;
            h3.next = head;
            ListNode pre = h1;
            ListNode p = h3;
            ListNode temp = null;
            int i = 0;
            while (p != null) {
                i = i + 1;
                p = p.next;
                pre = pre.next;
                if (i % 2 == 0 && p != null) {
                    temp = pre.next;
                    pre.next = temp.next;
                    temp.next = pre.next.next;
                    pre.next.next = temp;
                    p = temp;
                }
            }
            return h3.next;
        }
    }
}
