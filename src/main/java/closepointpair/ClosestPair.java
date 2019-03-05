package closepointpair;

import java.util.Arrays;

public class ClosestPair {

    private Point2D best1, best2;
    private double bestDistance = Double.POSITIVE_INFINITY;

    ClosestPair(Point2D[] points) {
        if (points == null) throw new IllegalArgumentException("constructor argument is null");
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) throw new IllegalArgumentException("array element " + i + " is null");
        }

        int n = points.length;
        if (n <= 1) return;

        Point2D[] pointsByX = new Point2D[n];
        System.arraycopy(points, 0, pointsByX, 0, n);
        Arrays.sort(pointsByX, Point2D.X_ORDER);

        for (int i = 0; i < n-1; i++) {
            if (pointsByX[i].equals(pointsByX[i + 1])) {
                bestDistance = 0.0;
                best1 = pointsByX[i];
                best2 = pointsByX[i + 1];
                return;
            }
        }

        Point2D[] pointsByY = new Point2D[n];
        System.arraycopy(pointsByX, 0, pointsByY, 0, n);

        Point2D[] aux = new Point2D[n];

        closest(pointsByX, pointsByY, aux, 0, n - 1);
    }

    private double closest(Point2D[] pointsByX, Point2D[] pointsByY, Point2D[] aux, int begin, int end) {
        if (end <= begin) return Double.POSITIVE_INFINITY;

        int mid = begin + (end - begin) / 2;
        Point2D median = pointsByX[mid];

        double delta1 = closest(pointsByX, pointsByY, aux, begin, mid);
        double delta2 = closest(pointsByX, pointsByY, aux, mid+1, end);
        double delta = Math.min(delta1, delta2);

        merge(pointsByY, aux, begin, mid, end);

        int m = 0;
        for (int i = begin; i <= end; i++) {
            if (Math.abs(pointsByY[i].x() - median.x()) < delta)
                aux[m++] = pointsByY[i];
        }

        for (int i = 0; i < m; i++) {
            for (int j = i+1; (j < m) && (aux[j].y() - aux[i].y() < delta); j++) {
                double distance = aux[i].distanceTo(aux[j]);
                if (distance < delta) {
                    delta = distance;
                    if (distance < bestDistance) {
                        bestDistance = delta;
                        best1 = aux[i];
                        best2 = aux[j];
                    }
                }
            }
        }
        return delta;
    }


    public Point2D either() {
        return best1;
    }

    public Point2D other() {
        return best2;
    }

    public double distance() {
        return bestDistance;
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void merge(Comparable[] a, Comparable[] aux, int begin, int mid, int end) {
        if (end + 1 - begin >= 0) System.arraycopy(a, begin, aux, begin, end + 1 - begin);

        int i = begin, j = mid+1;
        for (int k = begin; k <= end; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > end) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }


}
