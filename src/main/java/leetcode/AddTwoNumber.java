package leetcode;

/**
 * @ProjectName: leetcode
 * @Description: java类作用描述
 * @Author: Tst
 * @CreateDate: 2018/7/22 下午12:46
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(8);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode listNode1 = createList(l1, l2);
        System.out.println(listNode1);
        ListNode listNode2 = createList(l4);
        System.out.println(listNode2);
        ListNode listNode3 = Solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode3);
    }




    private static ListNode createList(ListNode... listNodes) {
        ListNode head = listNodes[0];
        ListNode last = head;
        for (int i = 1; i < listNodes.length; i++) {
            last.next = listNodes[i];
            last = listNodes[i];
        }
        return head;
    }



    /**
     * 注意有进位的情况。
     * 当第一个循环结束且两个双向链表同时为空时，此时看进位是否不为0，如果不为零则需要为它创建一个ListNode
     * 当第一个循环结束且其中有一个链表不为空时，此时继续合并，最后也要观察进位是否不为0。
     */
    static class Solution {
        static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null;
            ListNode last = null;
            int carry = 0;
            int state = 0;
            do {
                state = l1.val + l2.val + carry;
                carry = state / 10;
                state = state % 10;
                ListNode temp = new ListNode(state);
                temp.next = null;
                if (head == null) {
                    head = temp;
                    last = temp;
                } else {
                    last.next = temp;
                    last = temp;
                }
            } while ((l1 = l1.next) != null & (l2 = l2.next) != null);
            System.out.println(head);
            if (l1 != null) {
                merge(l1, last, carry);
            } else if (l2 != null) {
                merge(l2, last, carry);
            } else if (carry != 0) {
                ListNode temp = new ListNode(carry);
                temp.next = null;
                last.next = temp;
            }
            return head;
        }

        private static void merge(ListNode listNode, ListNode last, int carry) {
            int state;
            while (listNode != null) {
                state = listNode.val + carry;
                carry = state / 10;
                state = state % 10;
                ListNode temp = new ListNode(state);
                temp.next = null;
                last.next = temp;
                last = temp;
                listNode = listNode.next;
            }
            if (carry != 0) {
                ListNode temp = new ListNode(carry);
                temp.next = null;
                last.next = temp;
            }
        }

    }

}




