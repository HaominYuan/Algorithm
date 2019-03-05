package leetcode;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static void main(String[] args) {
//        intervals = [[1,3],[6,9]], newInterval = [2,5]
        List<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 5));
//        lists.add(new Interval(6, 9));
        System.out.println(new Solution().insert(list, new Interval(0, 0)));
    }


    static class Solution {
        public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
            List<Interval> list = new ArrayList<>();
            if (intervals.size() == 0) {
                list.add(newInterval);
                return list;
            }

            int start = intervals.get(0).start, end = intervals.get(0).end;
            int flag = 0;
            for (int i = 0; i < intervals.size(); i++) {
                if (flag == 0) {
                    if (intervals.get(i).end < newInterval.start) {
                        list.add(intervals.get(i));
                    } else {

                        if (newInterval.end < intervals.get(i).start) {
                            list.add(newInterval);
                            list.add(intervals.get(i));
                            flag = 2;
                        } else {
                            start = Math.min(intervals.get(i).start, newInterval.start);
                            end = Math.max(intervals.get(i).end, newInterval.end);
                            flag = 1;
                        }
                    }
                } else if (flag == 1) {
                    if (intervals.get(i).start <= end) {
                        end = Math.max(end, intervals.get(i).end);
                    } else {
                        list.add(new Interval(start, end));
                        list.add(intervals.get(i));
                        flag = 2;
                    }
                } else {
                    list.add(intervals.get(i));
                }
            }
            if (flag == 0) {
                list.add(newInterval);
            } else if (flag == 1) {
                list.add(new Interval(start, end));
            }
            return list;
        }
    }
}
