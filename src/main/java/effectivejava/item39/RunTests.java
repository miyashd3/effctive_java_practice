package effectivejava.item39;

import java.lang.reflect.*;

public class RunTests {

    public static void main(String[] args) throws Exception {
        // テスト対象クラスを指定
        Class<?> testClass = Class.forName("effectivejava.item39.Sample");

        int tests = 0;
        int passed = 0;

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) { // ← @Testがあるかチェック
                tests++;
                try {
                    m.invoke(null); // staticメソッドを実行
                    passed++;
                } catch (InvocationTargetException wrappedEx) {
                    Throwable exc = wrappedEx.getCause();
                    System.out.printf("メソッド %s で例外: %s%n", m.getName(), exc);
                } catch (Exception exc) {
                    System.out.printf("メソッド %s の実行に失敗: %s%n", m.getName(), exc);
                }
            }
        }

        System.out.printf("合計: %d, 成功: %d, 失敗: %d%n",
                tests, passed, tests - passed);
    }
}
