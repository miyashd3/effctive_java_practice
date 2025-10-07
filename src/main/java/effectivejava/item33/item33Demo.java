package effectivejava.item33;



public class item33Demo {
    public static void main(String[] args) {
        Favorites favorites = new Favorites();

        // いろんな型を安全に登録
        favorites.putFavorite(String.class, "Hello World");
        favorites.putFavorite(Integer.class, 42);
        favorites.putFavorite(Class.class, Favorites.class);

        // 安全に取得
        String s = favorites.getFavorite(String.class);
        Integer i = favorites.getFavorite(Integer.class);
        Class<?> c = favorites.getFavorite(Class.class);

        // 結果を表示
        System.out.println("String: " + s);
        System.out.println("Integer: " + i);
        System.out.println("Class: " + c.getName());
    }
}
