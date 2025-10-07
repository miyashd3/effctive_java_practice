package effectivejava.item33;

import java.util.HashMap;
import java.util.Map;

public class Favorites {
    private final Map<Class<?>, Object> favorites = new HashMap<>();

    // 値を保存
    public <T> void putFavorite(Class<T> type, T instance) {
        favorites.put(type, instance);
    }

    // 値を取得（型安全に）
    public <T> T getFavorite(Class<T> type) {
        return type.cast(favorites.get(type));
    }
}
