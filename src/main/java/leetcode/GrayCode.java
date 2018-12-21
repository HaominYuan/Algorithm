package leetcode;

import java.util.LinkedList;
import java.util.List;

public class GrayCode {
    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(4));
    }

    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> list = new LinkedList<>();
            List<Integer> list1 = new LinkedList<>();
            list.add(0);
            int length = (int) Math.pow(2, n);
            int last = 0;

            for (int i = 1; i < length; i++) {
                list1.add(i);
            }



            while (list1.size() != 0) {
                int i = 0;
                while (i < list1.size()) {
                    if (((last ^ list1.get(i)) & ((last ^ list1.get(i)) - 1)) == 0) {
                        last = list1.get(i);
                        list.add(last);
                        list1.remove(i);
                    } else {
                        i = i + 1;
                    }
                }
                System.out.println(last);
                System.out.println(list1);
            }



            return list;
        }
    }
}
