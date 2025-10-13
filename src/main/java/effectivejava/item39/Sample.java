package effectivejava.item39;

public class Sample {

    @Test
    public static void test1() {
        System.out.println("test1 実行中！");
    }

    public static void test2() {
        System.out.println("test2 は @Test がないので実行されません");
    }

    @Test
    public static void test3() {
        throw new RuntimeException("test3 で例外発生！");
    }
}
