package leetcode;

public class RemoveDuplicatesFromSortedListII {
    public static void main(String[] args) {

//        1->2->3->3->4->4->5
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(4);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
//        listNode6.next = listNode7;
        System.out.println(new Solution().deleteDuplicates(listNode1));
    }

    static class MySolution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null) {
                return null;
            }

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode p1 = dummy;
            ListNode p2 = dummy.next;
            ListNode p3 = p2.next;
            int last = head.val;
            while (p3 != null) {
                if (p2.val == p3.val || last == p3.val) {
                    p2 = p1;
                    p1.next = p3.next;
                } else {
                    if (p1 == p2) {
                        p2.next = p3;
                        p2 = p2.next;
                    } else {
                        p2.next = p3;
                        p2 = p2.next;
                        p1 = p1.next;
                    }
                }
                last = p3.val;
                p3 = p3.next;
            }
            return dummy.next;
        }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            // 如果头链表中没有或者只有一个节点，那么直接返回
            if (head == null || head.next == null) {
                return head;
            }

            // 如果后一个元素和前一个元素不想等，那么不用删除，否则直接到没有不重复的元素位置
            if (head.val != head.next.val) {
                head.next = deleteDuplicates(head.next);
                return head;
            } else {
                while ((head = head.next).next != null && (head.val == head.next.val)) {
                }
                return deleteDuplicates(head.next);
            }
        }
    }

}
