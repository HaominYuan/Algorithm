package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {
    public static void main(String[] args) {
        int[][] edges = new int[1][2];
        edges[0] = new int[]{0, 1};
//        edges[1] = new int[]{0, 1};
        System.out.println(new MySolution().canFinish(2, edges));
    }

    static class MySolution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<List<Integer>> edges = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                edges.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                edges.get(prerequisite[0]).add(prerequisite[1]);
            }

            boolean[] isVisited = new boolean[numCourses];
            boolean[] isOnStack = new boolean[numCourses];
            for (int i = 0; i < isVisited.length; i++) {
                if (!isVisited[i]) {
                    if (!dfs(edges, isVisited, isOnStack, i)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dfs(List<List<Integer>> edges, boolean[] isVisited, boolean[] isOnStack, int index) {
            isVisited[index] = true;
            isOnStack[index] = true;
            List<Integer> list = edges.get(index);
            // 遍历每个节点
            for (Integer nextVertex : list) {
                if (isOnStack[nextVertex]) {
                    return false;
                }

                if (isVisited[nextVertex] && !dfs(edges, isVisited, isOnStack, nextVertex)) {
                    return false;
                }
            }
            isOnStack[index] = false;
            return true;
        }
    }


    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList[] graph = new ArrayList[numCourses];
            for (int i = 0; i < numCourses; i++)
                graph[i] = new ArrayList<>();
            for (int[] prerequisite : prerequisites){
                graph[prerequisite[1]].add(prerequisite[0]);
            }

            int[] d = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(graph, d, i))
                    return false;
            }
            return true;
        }

        private boolean dfs(List<Integer>[] graph, int[] state, int index) {
            // 1 表示访问过，但是不是在同一条路上
            if (state[index] == 1) {
                return true;
            }

            // -1 表示访问过，并且是在同一条路上
            if (state[index] == -1) {
                return false;
            }

            state[index] = -1;
            for (int i = 0; i < graph[index].size(); i++) {
                if (!dfs(graph, state, graph[index].get(i)))
                    return false;
            }
            state[index] = 1;
            return true;
        }
    }
}
