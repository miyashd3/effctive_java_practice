package effectivejava.item34;

public class BadOperation {
    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int TIMES = 2;
    public static final int DIVIDE = 3;

    public static double apply(int op, double x, double y) {
        switch (op) {
            case PLUS:   return x + y;
            case MINUS:  return x - y;
            case TIMES:  return x * y;
            case DIVIDE: return x / y;
            default:
                throw new IllegalArgumentException("不正な操作: " + op);
        }
    }
}
