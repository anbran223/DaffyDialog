# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.brandonang.daffydialog.DaffyDialog {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/brandonang/daffydialog/repack'
-flattenpackagehierarchy
-dontpreverify
