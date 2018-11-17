package csp;

import java.util.*;

public class Agent {

    int X;
    HashMap<Double, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        int K = 4, M = 8, N = 4;

        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);list.add(3);list.add(4);list.add(3);
        list.add(3);list.add(2);list.add(3);list.add(3);
        list.add(2);list.add(4);list.add(3);list.add(4);
        list.add(1);list.add(3);list.add(4);list.add(3);
        list.add(3);list.add(3);list.add(1);list.add(1);
        list.add(3);list.add(4);list.add(3);list.add(3);
        list.add(1);list.add(4);list.add(4);list.add(3);
        list.add(1);list.add(2);list.add(3);list.add(2);

        Game game = new Game(K, M, N, list);

        Agent agent = new Agent();
        agent.X = 100;


//        这个是近似算法
        System.out.println(agent.greedySearch(game, 0));
//        这个是优化过的
        System.out.println(agent.func(game, 0));
//        这个是没有优化过
        System.out.println(agent.func1(game, 0));
        // 这个函数输出结果，每一步都显示
        agent.displayPath(game);

//        double sum1 = 0;
//        double sum2 = 0;
//        double time1 = 0;
//        double time2 = 0;
//        double time3 = 0;
//        for (int i = 0; i < 100; i++) {
//            game = Game.create(4, 7, 7);
//            time1 = System.currentTimeMillis();
//            agent.func1(game, 0);
//            Game copy = (Game) game.clone();
//            time2 = System.currentTimeMillis();
//            agent.func(copy, 0);
//            time3 = System.currentTimeMillis();
//            agent.hashMap.clear();
//            sum1 = sum1 + time2 - time1;
//            sum2 = sum2 + time3 - time2;
//            System.out.println(sum2);
//        }
//        System.out.println(sum1 / sum2);





//        System.out.println(agent.backtrackingSearch(game, 2));
//        System.out.println(agent.greedySearch(game, 0));

//        game = Game.create(K, M, N);
//        for (int i = 0; i < game.map.length; i++) {
//            for (int j = 0; j < game.map[i].length; j++) {
//                System.out.print(game.map[i][j] + " ");
//            }
//            System.out.println();
//
//        }


//        double sum = 0;
//        int time = 10000;
//        for (int i = 0; i < time; i++) {
//            game = Game.create(K, M, N);
//            int score1 = agent.backtrackingSearch((Game) game.clone(), 0).score;
//            int score2 = agent.greedySearch(game, 0).score;
//            if (score1 != 0) {
//                sum = sum + (score1 - score2 + 0.0) / score1;
//            } else {
//                time = time - 1;
//            }
//        }
//        System.out.println(sum / time);
    }



    private void displayPath(Game game) throws CloneNotSupportedException {
        Stack<Operation> step = this.backtrackingSearch((Game) game.clone(), 0).operations;
        while (!step.isEmpty()) {
            System.out.println(game);
            Operation operation = step.pop();
            if (operation.getDirection() == 0) {
                game.rightExchangeScore(operation.getX(), operation.getY());
                System.out.println(operation.getX() + " " + operation.getY() + " right\n");
            } else {
                game.downExchangeScore(operation.getX(), operation.getY());
                System.out.println(operation.getX() + " " + operation.getY() + " down\n");
            }
        }
    }

    private Step backtrackingSearch(Game game, int depth) throws CloneNotSupportedException {

        if (depth == X) {
            return new Step();
        }



        Game temp;
        Step max = new Step();
        Step next = new Step();
        int right, down;

        for (int i = 0; i < game.map.length; i++) {
            for (int j = 0; j < game.map[i].length; j++) {

                if (j != game.map[i].length - 1) {

                    temp = (Game) game.clone();
                    right = temp.rightExchangeScore(i, j);
                    if (right != 0) {
                        next = backtrackingSearch(temp, depth + 1);
                    }
                    if (right + next.score > max.score) {
                        next.score = next.score + right;
                        next.operations.add(new Operation(i, j, 0));
                        max = next;
                    }
                }


                if (i != game.map.length - 1) {
                    temp = (Game) game.clone();
                    down = temp.downExchangeScore(i, j);
                    if (down != 0) {
                        next = backtrackingSearch(temp, depth + 1);
                    }
                    if (down + next.score > max.score) {
                        next.score = next.score + down;
                        next.operations.add(new Operation(i, j, 1));
                        max = next;
                    }
                }
            }
        }
        return max;
    }

    private Integer func1(Game game, int depth) throws CloneNotSupportedException {
        if (depth == X) {
            return 0;
        }

        Game temp;

        int right, down, next = 0, max = 0;

        for (int i = 0; i < game.map.length; i++) {
            for (int j = 0; j < game.map[i].length; j++) {
                if (j != game.map[i].length - 1) {
                    temp = (Game) game.clone();
                    right = temp.rightExchangeScore(i, j);
                    if (right != 0) {
                        next = func1(temp, depth + 1);
                    }
                    if (right + next > max) {
                        max = next + right;
                    }
                }

                if (i != game.map.length - 1) {
                    temp = (Game) game.clone();
                    down = temp.downExchangeScore(i, j);
                    if (down != 0) {
                        next = func1(temp, depth + 1);
                    }
                    if (down + next > max) {
                        max = next + down;
                    }
                }
            }
        }
        return max;
    }

    private Integer func(Game game, int depth) throws CloneNotSupportedException {
        if (depth == X) {
            return 0;
        }

        if (hashMap.containsKey(game.hash())) {
            return hashMap.get(game.hash());
        }

        Game temp;

        int right, down, next = 0, max = 0;

        for (int i = 0; i < game.map.length; i++) {
            for (int j = 0; j < game.map[i].length; j++) {
                if (j != game.map[i].length - 1) {
                    temp = (Game) game.clone();
                    right = temp.rightExchangeScore(i, j);
                    if (right != 0) {
                        next = func(temp, depth + 1);
                    }
                    if (right + next > max) {
                        max = next + right;
                    }
                }

                if (i != game.map.length - 1) {
                    temp = (Game) game.clone();
                    down = temp.downExchangeScore(i, j);
                    if (down != 0) {
                        next = func(temp, depth + 1);
                    }
                    if (down + next > max) {
                        max = next + down;
                    }
                }
            }
        }
        hashMap.put(game.hash(), max);
        return max;
    }




    private Step greedySearch(Game game, int depth) throws CloneNotSupportedException {

        if (depth == X) {
            return new Step();
        }


        Game copy;
        int right, down;
        int maxScore = 1;
        Queue<Operation> queue = new ArrayDeque<>();
        Queue<Game> queue1 = new ArrayDeque<>();
        Queue<Integer> queue2 = new ArrayDeque<>();
        Step step;

        for (int i = 0; i < game.map.length; i++) {
            for (int j = 0; j < game.map[i].length - 1; j++) {
                copy = (Game) game.clone();
                right = copy.rightExchangeScore(i, j);
                if (right >= maxScore) {
                    maxScore = right;
                    queue.add(new Operation(i, j, 0));
                    queue1.add(copy);
                    queue2.add(maxScore);
                }
                if (i != game.map.length - 1) {
                    copy = (Game) game.clone();
                    down = copy.downExchangeScore(i, j);
                    if (down >= maxScore) {
                        maxScore = down;
                        queue.add(new Operation(i, j, 1));
                        queue1.add(copy);
                        queue2.add(maxScore);
                    }
                }
            }
        }

        if (!queue.isEmpty()) {
            Step maxStep = new Step();
            while (!queue2.isEmpty()) {
                int score = queue2.poll();
                if (score == maxScore) {
                    step = greedySearch(queue1.poll(), depth + 1);
                    step.operations.add(queue.poll());
                    step.score = step.score + score;
                    if (step.score > maxStep.score) {
                        maxStep = step;
                    }
                } else {
                    queue1.poll();
                    queue.poll();
                }
            }
            return maxStep;
        } else {
            return new Step();
        }
    }

}
