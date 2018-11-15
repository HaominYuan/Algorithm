package closepointpair;

class Utils {
    static Double[][] generalNPoint(int n) {
        Double[][] pairPoint = new Double[n][];
        for (int i = 0; i < n; i++) {
            pairPoint[i] = new Double[2];
            for (int j = 0; j < 2; j++) {
                pairPoint[i][j] = Math.random();
            }
        }
        return pairPoint;
    }
}
