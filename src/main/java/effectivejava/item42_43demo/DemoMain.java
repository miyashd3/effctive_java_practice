package effectivejava.item42_43demo;

import java.util.*;

public class DemoMain {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(List.of("banana", "apple", "peach", "kiwi"));

        // ① 無名クラス
        words.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return Integer.compare(a.length(), b.length());
            }
        });
        System.out.println("① 無名クラス：" + words);

        // ② ラムダ式
        words = new ArrayList<>(List.of("banana", "apple", "peach", "kiwi"));
        words.sort((a, b) -> Integer.compare(a.length(), b.length()));
        System.out.println("② ラムダ式：" + words);

        // ③ メソッド参照
        words = new ArrayList<>(List.of("banana", "apple", "peach", "kiwi"));
        words.sort(Comparator.comparingInt(String::length));
        System.out.println("③ メソッド参照：" + words);
    }
}
