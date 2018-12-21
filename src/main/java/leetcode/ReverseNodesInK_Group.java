package leetcode;

import java.util.Stack;

public class ReverseNodesInK_Group {
    public static void main(String[] args) {
//        1->2->3->4->5
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        leetcode.ListNode listNode6 = new leetcode.ListNode(6);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        System.out.println(new MySolution().reverseKGroup(listNode1, 3));
    }


    static class MySolution {
        ListNode reverseKGroup(ListNode head, int k) {

            ListNode temp = new ListNode(0);
            ListNode fuck = temp;
            temp.next = head;
            int count = 0;
            do {
                if (count % k == 0) {
                    func(temp, k);
                }
                count = count + 1;
                temp = temp.next;
            } while (temp != null);
            return fuck.next;
        }

        void func(ListNode head, int k) {
            ListNode last = head;
            Stack<ListNode> stack = new Stack<>();
            for (int i = 0; i < k; i++) {
                if ((last = last.next) == null) {
                    return;
                } else {
                    stack.add(last);
                }
            }
            last = stack.pop();
            ListNode lastNext = last.next;
            head.next = last;
            while (!stack.isEmpty()) {
                last.next = stack.pop();
                last = last.next;
            }
            last.next = lastNext;
        }
    }


    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode pre = dummy;
            ListNode cur = head;

            int i = 0;
            while (cur != null) {
                i = i + 1;
                if (i % k == 0) {
                    pre = reverse(pre, cur.next);
                    cur = pre.next;
                } else {
                    cur = cur.next;
                }
            }
            return dummy.next;
        }

        ListNode reverse(ListNode pre, ListNode next) {
            // 这里的last相当于固定的链表的最后的位置
            ListNode last = pre.next;
            ListNode cur = last.next;
            while (next != cur) {
                last.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
                cur = last.next;
            }
            return last;
        }
    }
}
