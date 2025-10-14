// AuditableAnno.java
package effectivejava.item41demo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// メタデータとして扱うためのマーカーアノテーション
@Retention(RetentionPolicy.RUNTIME)
public @interface AuditableAnno {}
