package effectivejava.item32;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestCode {

    @SafeVarargs
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> List<T> pickTwo(T a, T b, T c) {
//        T[] result;
        switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0: return List.of(a, b);
            case 1: return List.of(a, c);
            case 2: return List.of(b, c);
            default: throw new AssertionError();
        }
        // 安全にコピーして T[] 型にする
//        return Arrays.copyOf(result, result.length, (Class<T[]>) result.getClass());
    }

    public static void main(String[] args) {
        List<String> result = pickTwo("A", "B", "C");
        for (String s : result) {
            System.out.println(s);
        }
    }
}
