package connectivity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Graph {
    private int vertex;
    private int edge;
    private List<Integer[]> list;
    private String path;
    private boolean[][] map;


    Graph(String path) {
        this.path = path;
        list = new ArrayList<>();
        readFile();
    }


    public int getVertex() {
        return vertex;
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
            vertex = Integer.parseInt(line);
            line = bufferedReader.readLine();
            edge = Integer.parseInt(line);
            map = new boolean[vertex][];
            for (int i = 0; i < map.length; i++) {
                map[i] = new boolean[vertex];
            }

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
