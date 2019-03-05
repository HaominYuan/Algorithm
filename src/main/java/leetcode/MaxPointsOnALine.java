//package leetcode;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class MaxPointsOnALine {
//    public static void main(String[] args) {
//
//    }
//
//    static class SortStackByStack {
//        public int maxPoints(Point[] points) {
//            Map<Double, Map<Double, Integer>> map = new HashMap<>();
//            for (int i = 0; i < points.length; i++) {
//                for (int j = i + 1; j < points.length; j++) {
//                    if (points[i].x == points[j].x) {
//                        put(map, Double.MAX_VALUE, points[i].x);
//                    } else {
//                        put(map, );
//                    }
//                }
//            }
//        }
//
//        void put(Map<Double, Map<Double, Integer>> map, double k, double b) {
//            if (map.containsKey(k)) {
//                Map<Double, Integer> temp = map.get(k);
//                temp.put(b, temp.get(b) + 1);
//            } else {
//                Map<Double, Integer> temp = new HashMap<>();
//                temp.put(b, 1);
//                map.put(k, temp);
//            }
//        }
//    }
//}
