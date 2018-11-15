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
            HashSet<Integer> set = new HashSet<>();
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

                int hash1 = x * vertex + y;
                int hash2 = y * vertex + x;
                if (set.contains(hash1) || set.contains(hash2)) {
                    continue;
                }
                set.add(hash1);
                set.add(hash2);
                list.add(new Integer[]{x, y});
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
