package connectivity;

public class CalTime {
    public static double calTime(CalBridge calBridge) {
        double start = System.currentTimeMillis();
        calBridge.calBridge();
        return System.currentTimeMillis() - start;
    }
}
