package connectivity;

import java.util.Arrays;

public class BruteForce implements CalBridge {
    private Graph graph;

    BruteForce(Graph graph) {
        this.graph = graph;
    }


    public int calBridge() {
        int original = calConnectedComponent();
        int sum = 0;
        boolean[][] map = graph.getMap();
        for (Integer[] aList : graph.getList()) {
            map[aList[0]][aList[1]] = false;
            map[aList[1]][aList[0]] = false;
            if (original < calConnectedComponent()) {
                sum = sum + 1;
//                System.out.println(Arrays.toString(aList));
            }
            map[aList[0]][aList[1]] = true;
            map[aList[1]][aList[0]] = true;
        }
        return sum;
    }


    private int calConnectedComponent() {
        boolean[] isVisited = new boolean[graph.getVertexNumber()];
        int sum = 0;
        for (int i = 0; i < graph.getVertexNumber(); i++) {
            if (!isVisited[i]) {
                dfs(i, isVisited);
                sum = sum + 1;
            }
        }
        return sum;
    }

    private void dfs(int startPoint, boolean[] isVisited) {
        isVisited[startPoint] = true;
        boolean[][] map = graph.getMap();
        for (int j = 0; j < graph.getVertexNumber(); j++) {
            if (map[startPoint][j] && !isVisited[j]) {
                dfs(j, isVisited);
            }
        }
    }
}
