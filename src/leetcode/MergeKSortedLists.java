package leetcode;

public class MergeKSortedLists {
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
        System.out.println(new Solution().mergeKLists(lists));

    }

    static class Solution {
        ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }
            return mergeLists(lists, 0, lists.length - 1);
        }


        ListNode mergeLists(ListNode[] lists, int begin, int end) {
            if (begin == end) {
                return lists[begin];
            }
            int mid = (begin + end) / 2;
            return merge(mergeLists(lists, begin, mid), mergeLists(lists, mid + 1, end));
        }



        private  ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    p.next = list1;
                    list1 = list1.next;
                } else {
                    p.next = list2;
                    list2 = list2.next;
                }
                p = p.next;
            }
            p.next = list1 != null ? list1 : list2;
            return dummy.next;
        }


    }
}
