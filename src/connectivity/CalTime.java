package connectivity;

class CalTime {
    static double calTime(CalBridge calBridge) {
        double start = System.currentTimeMillis();
        calBridge.calBridge();
        return System.currentTimeMillis() - start;
    }
}
