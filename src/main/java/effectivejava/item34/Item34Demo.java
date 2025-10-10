package effectivejava.item34;

import java.util.Optional;

public class Item34Demo {
    public static void main(String[] args) {
        System.out.println("=== int定数版（BadOperation）===");
        double x = 10, y = 4;
        System.out.println("10 + 4 = " + BadOperation.apply(BadOperation.PLUS, x, y));
        System.out.println("10 - 4 = " + BadOperation.apply(BadOperation.MINUS, x, y));

        // 不正値を渡してもコンパイル時に気づけない
        try {
            BadOperation.apply(99, x, y);
        } catch (Exception e) {
            System.out.println("エラー（BadOperation）: " + e.getMessage());
        }

        System.out.println("\n=== enum版（Operation）===");
        for (Operation op : Operation.values()) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }

        System.out.println("\n=== fromStringで安全に取得 ===");
        Optional<Operation> plus = Operation.fromString("+");
        plus.ifPresent(o -> System.out.println("10 + 4 = " + o.apply(x, y)));

        Optional<Operation> unknown = Operation.fromString("×");
        System.out.println("存在しない演算子 '×': " + unknown);
    }
}
