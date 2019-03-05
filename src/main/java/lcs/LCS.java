package lcs;

class LCS {
    private static int solveLCS(String x, String y) {

        if (y.length() > x.length()) {
            String temp = x;
            x = y;
            y = temp;
        }


        int[] states = new int[y.length() + 1];
        for (int i = 1; i < x.length() + 1; i++) {
            int last = states[0];
            for (int j = 1; j < y.length() + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    int temp = states[j];
                    states[j] = last + 1;
                    last = temp;
                } else {
                    last = states[j];
                    states[j] = Math.max(states[j], states[j - 1]);
                }
            }
        }
        return states[y.length()];
    }

    static String findLCSString(String x, String y) {
        if (x.length() == 0) {
            return "";
        }

        if (x.length() == 1) {
            for (int i = 0; i < y.length(); i++) {
                if (y.charAt(i) == x.charAt(0))
                    return x;
            }
            return "";
        }


        int c = solveLCS(x, y);

        String x1 = x.substring(0, x.length() / 2);
        String x2 = x.substring(x.length() / 2);

        int k;
        for (k = 0; k < y.length(); k++) {
            if (solveLCS(x1, y.substring(0, k)) + solveLCS(x2, y.substring(k)) == c) {
                break;
            }
        }

        String y1 = y.substring(0, k);
        String y2 = y.substring(k);


        String sol1 = findLCSString(x1, y1);
        String sol2 = findLCSString(x2, y2);

        return sol1 + sol2;
    }

    static double calSimilarity(String x, String y) {
        if (x.length() == 0 || y.length() == 0) {
            return 0;
        }
        return (double) solveLCS(x, y) / Math.min(x.length(), y.length());
    }

    static int calMaximumNum(Boolean[][] matrix) {
        int[][] states = new int[2][];
        for (int i = 0; i < states.length; i++) {
            states[i] = new int[matrix[0].length + 1];
        }

        for (int i = 1; i < matrix.length + 1; i++) {
            System.arraycopy(states[1], 0, states[0], 0, matrix[0].length + 1);
            states[1][0] = 0;
            for (int j = 1; j < matrix[0].length + 1; j++) {
                if (matrix[i - 1][j - 1]) {
                    states[1][j] = states[0][j - 1] + 1;
                } else {
                    states[1][j] = Math.max(states[0][j], states[1][j - 1]);
                }
            }
        }
        return states[1][matrix[0].length];
    }
}
