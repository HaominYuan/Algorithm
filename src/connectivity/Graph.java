package connectivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Graph {
    private int vertexNumber;
    private int edgeNumber;
    private List<Integer[]> list;
    private String path;
    private boolean[][] map;

    Graph(int verticeNumber, int edgeNumber) {
        this.vertexNumber = verticeNumber;
        this.edgeNumber = edgeNumber;
        Set<Integer> set = new HashSet<>();
        map = new boolean[verticeNumber][verticeNumber];
        list = new ArrayList<>();
        for (int i = 0; i < edgeNumber; i++) {
            int num1 = (int) (Math.random() * verticeNumber);
            int num2 = (int) (Math.random() * verticeNumber);
            if (num1 == num2 || set.contains(num1 * verticeNumber + num2)) {
                i = i - 1;
            } else {
                set.add(num1 * verticeNumber + num2);
                set.add(num2 * verticeNumber + num1);
                map[num1][num2] = map[num2][num1] = true;
            }
        }
        toList();
    }

    Graph(String path) {
        this.path = path;
        list = new ArrayList<>();
        readFile();
    }




    public int getVertexNumber() {
        return vertexNumber;
    }

    public List<Integer[]> getList() {
        return list;
    }

    public boolean[][] getMap() {
        return map;
    }

    private void readFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line;
            line = bufferedReader.readLine();
            vertexNumber = Integer.parseInt(line);
            line = bufferedReader.readLine();
            edgeNumber = Integer.parseInt(line);
            map = new boolean[vertexNumber][vertexNumber];

            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(" ");
                int x = Integer.parseInt(strings[0]);
                int y = Integer.parseInt(strings[1]);
                map[x][y] = true;
                map[y][x] = true;
            }
            toList();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void toList() {
        for (int i = 0; i < map.length; i++) {
            for (int j = i + 1; j < map.length; j++) {
                if (map[i][j]) {
                    list.add(new Integer[]{i, j});
                }
            }
        }
    }



}
