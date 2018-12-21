package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        list.add(new Interval(15, 18));
        System.out.println(new Solution().merge(list));
    }




    static class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if (intervals.size() == 0) {
                return new ArrayList<>();
            }

            intervals.sort(Comparator.comparingInt(o -> o.start));



            List<Interval> list = new ArrayList<>();
            int start = intervals.get(0).start, end = intervals.get(0).end;
            for (int i = 1; i < intervals.size(); i++) {
                if (intervals.get(i).start <= end) {
                    end = Math.max(end, intervals.get(i).end);
                } else {
                    list.add(new Interval(start, end));
                    start = intervals.get(i).start;
                    end = intervals.get(i).end;
                }
            }
            list.add(new Interval(start, end));
            return list;
        }
    }

}
