package leetcode;

public class MergeKSortedLists {
//    Input:
//            [
//            1->4->5,
//            1->3->4,
//            2->6
//            ]
//    Output: 1->1->2->3->4->4->5->6
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(1);
        ListNode listNode12 = new ListNode(4);
        listNode11.next = listNode12;
        listNode12.next = new ListNode(5);

        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(3);
        listNode21.next = listNode22;
        listNode22.next = new ListNode(4);

        ListNode listNode31 = new ListNode(2);
        listNode31.next = new ListNode(6);

        ListNode[] lists = new ListNode[3];
        lists[0] = listNode11;
        lists[1] = listNode21;
        lists[2] = listNode31;
        System.out.println(Solution.mergeKLists(lists));

    }

    static class Solution {
        static ListNode mergeKLists(ListNode[] lists) {
            ListNode head = null;
            for (ListNode list : lists) {
                head = merge(head, list);
            }
            return head;
        }

        private static ListNode merge(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(0);
            head.next = list1;
            ListNode p = head.next;
            ListNode pre = head;
            ListNode temp = null;
            while (p != null && list2 != null) {
                if (p.val <= list2.val) {
                    p = p.next;
                    pre = pre.next;
                } else {
                    pre.next = list2;
                    list2 = list2.next;
                    pre.next.next = p;
                    pre = pre.next;
                }
            }

            if (list2 != null) {
                pre.next = list2;
            }
            return head.next;
        }


    }
}
