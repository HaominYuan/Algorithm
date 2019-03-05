package csp;

import java.util.*;

public class Game implements Cloneable {
    int[][] map;
    int K;
    int hashcode = -1;




    Game(int K, int M, int N, List<Integer> list) {
        this(K, M, N);
        for (int i = 0, k = 0; i < this.map.length; i++) {
            for (int j = 0; j < this.map[i].length; j++) {
                map[i][j] = list.get(k++);
            }
        }
    }

    static Game create(int K, int M, int N) {
        Game game = new Game(K, M, N);
        for (int i = 0; i < game.map.length; i++) {
            for (int j = 0; j < game.map[i].length; j++) {
                game.map[i][j] = ((int) (Math.random() * 100)) % (K - 1) + 1;
            }
        }
        while (game.calScore() != 0) {
            for (int i = 0; i < game.map.length; i++) {
                for (int j = 0; j < game.map[i].length; j++) {
                    if (game.map[i][j] == 0) {
                        game.map[i][j] = ((int) (Math.random() * 100)) % (K - 1) + 1;
                    }
                }
            }
        }


        return game;
    }

    private Game(int K, int M, int N) {
        this.K = K;
        this.map = new int[M][];
        for (int i = 0; i < this.map.length; i++) {
            this.map[i] = new int[N];
        }
    }

    int rightExchangeScore(int x, int y) {
        if (map[x][y] == 0 || map[x][y + 1] == 0) {
            return 0;
        }
        int temp = map[x][y];
        map[x][y] = map[x][y + 1];
        map[x][y + 1] = temp;
        return calScore();
    }

    int downExchangeScore(int x, int y) {
        if (map[x][y] == 0 || map[x + 1][y] == 0) {
            return 0;
        }
        int temp = map[x][y];
        map[x][y] = map[x + 1][y];
        map[x + 1][y] = temp;
        return calScore();
    }


    private int calScore() {
        int sum = 0, score;
//        如果得分等于零，则不需要整理，跳出循环
        while ((score = cal()) != 0) {
            sum = sum + score;
//            如果不需要整理，则意味着已经没办法再交换，跳出循环
            if (!arrange()) {
                break;
            }
        }
        return sum;
    }


    private int cal() {
        HashSet<Integer[]> delete = new HashSet<>();
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < map.length; i++) {
            int type = 0;
            int count = 0;
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != type) {
                    if (count >= 3 && type != 0) {
                        if (!counter.containsKey(count)) {
                            counter.put(count, 1);
                        } else {
                            counter.put(count, counter.get(count) + 1);
                        }
                        for (int k = 1; k <= count; k++) {
                            delete.add(new Integer[]{i, j - k});
                        }
                    }
                    type = map[i][j];
                    count = 1;
                } else {
                    count = count + 1;
                }
            }


            if (count >= 3 && type != 0) {
                if (!counter.containsKey(count)) {
                    counter.put(count, 1);
                } else {
                    counter.put(count, counter.get(count) + 1);
                }
                for (int k = 1; k <= count; k++) {
                    delete.add(new Integer[]{i, map[i].length - k});
                }
            }


        }

        for (int j = 0; j < map[0].length; j++) {
            int type = 0;
            int count = 0;
            for (int i = 0; i < map.length; i++) {
                if (map[i][j] != type) {
                    if (count >= 3 && type != 0) {
                        if (!counter.containsKey(count)) {
                            counter.put(count, 1);
                        } else {
                            counter.put(count, counter.get(count) + 1);
                        }
                        for (int k = 1; k <= count; k++) {
                            delete.add(new Integer[]{i - k, j});
                        }
                    }
                    type = map[i][j];
                    count = 1;
                } else {
                    count = count + 1;
                }
            }

            if (count >= 3 && type != 0) {
                if (!counter.containsKey(count)) {
                    counter.put(count, 1);
                } else {
                    counter.put(count, counter.get(count) + 1);
                }
                for (int k = 1; k <= count; k++) {
                    delete.add(new Integer[]{map.length - k, j});
                }
            }

        }


        for (Integer[] integers : delete) {
            map[integers[0]][integers[1]] = 0;
        }

        int score = 0;
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getKey() == 3) {
                score = score + entry.getValue();
            } else if (entry.getKey() == 4) {
                score = score + entry.getValue() * 4;
            } else if (entry.getValue() == 5) {
                score = score + entry.getValue() * 10;
            }
        }
        return score;
    }

    private boolean arrange() {
        boolean flag = false;
        int width = map[0].length;
        int height = map.length;
//      遍历列，从下向上遍历，如果出现不是零的元素，需要将它交换至一列的最小面
        for (int j = 0; j < width; j++) {
            int index = height - 1;
            for (int i = height - 1; i >= 0; i--) {
                if (map[i][j] != 0) {
                    if (i != index) {
                        map[index][j] = map[i][j];
                        map[i][j] = 0;
                        flag = true;
                    }
                    index = index - 1;
                }
            }
        }
        return flag;
    }




    @Override
    protected Object clone() throws CloneNotSupportedException {
        Game newGame = (Game) super.clone();
        int[][] newMap = new int[map.length][];
        for (int i = 0; i < newMap.length; i++) {
            newMap[i] = map[i].clone();
        }
        newGame.map = newMap;
        return newGame;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] aMap : map) {
            for (int anAMap : aMap) {
                stringBuilder.append(anAMap).append(" ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Double hash() {
        double hash = (double) 0;
        for (int[] aMap : map) {
            for (int anAMap : aMap) {
                hash = hash * (K + 1) + anAMap;
            }
        }
        return hash;
    }

}
