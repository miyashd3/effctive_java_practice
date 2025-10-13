package effectivejava.item39;

import java.lang.annotation.*;

// 実行時に参照できるようにする
@Retention(RetentionPolicy.RUNTIME)
// メソッドにだけ付けられるようにする
@Target(ElementType.METHOD)
public @interface Test {
}
