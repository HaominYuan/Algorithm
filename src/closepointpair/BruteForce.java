package closepointpair;


class BruteForce {
    static double func(Double[][] points) {
        return func(points, 0, points.length - 1);
    }

    static double func(Double[][] points, int begin, int end) {
        if (begin == end) {
            return Double.MAX_VALUE;
        }
        double min = Double.MAX_VALUE;
        double distance = 0;
        int length = end - begin + 1;
        int index1 = 0, index2 = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                distance = Math.pow(points[i + begin][0] - points[j + begin][0], 2) +
                        Math.pow(points[i + begin][1] - points[j + begin][1], 2);
                if (distance < min) {
                    min = distance;
                    index1 = i;
                    index2 = j;
                }
            }
        }
        return Math.pow(min, 0.5);
    }

}
