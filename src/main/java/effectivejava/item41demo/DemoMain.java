// DemoMain.java
package effectivejava.item41demo;

public class DemoMain {

    public static void main(String[] args) {
        Object u1 = new UserByInterface();
        Object u2 = new UserByAnnotation();

        // ✅ マーカーインターフェースは「型」として扱える
        if (u1 instanceof Auditable) {
            System.out.println("UserByInterface は監査対象（型チェックで判定）");
        }

        // ❌ アノテーションは型ではないため instanceof では判定できない
        // if (u2 instanceof AuditableAnno) ← コンパイルエラー

        // ✅ マーカーアノテーションは「メタデータ」として扱う
        if (u2.getClass().isAnnotationPresent(AuditableAnno.class)) {
            System.out.println("UserByAnnotation は監査対象（アノテーションで判定）");
        }

        // ❌ インターフェース実装はアノテーションでは取れない
        if (!u1.getClass().isAnnotationPresent(AuditableAnno.class)) {
            System.out.println("UserByInterface はアノテーション監査対象ではない");
        }
    }
}
