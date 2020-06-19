package test;

import io.xjar.XEntryFilter;
import io.xjar.XKit;
import io.xjar.jar.XJar;
import io.xjar.key.XKey;
import org.apache.commons.compress.archivers.jar.JarArchiveEntry;

/**
 *
 * 基于 2.x 版本
 * jar包加解密
 *
 * Created by zhoub on 2020/6/19.
 */
public class Encrypt {

    //jar包启动是否输入密码
    public static final boolean INPUT_HIDE = true;
    public static final String PASSWORD = "io.xjar";

    //原jar包
    private static final String JAR_ORIGIN = "D:/workspace/origin.jar";
    //加密后的jar
    private static final String TARGET = "D:/workspace/target.jar";

    public static void main(String[] args) throws Exception {

        // Spring-Boot Jar包加密
        /*String password = "io.xjar";
        XKey xKey = XKit.key(password);
        XBoot.encrypt("/path/to/read/plaintext.jar", "/path/to/save/encrypted.jar", xKey);*/


        // 危险加密模式，即不需要输入密码即可启动的加密方式，这种方式META-INF/MANIFEST.MF中会保留密钥，请谨慎使用！
        /*String password = "io.xjar";
        XKey xKey = XKit.key(password);
        XBoot.encrypt("/path/to/read/plaintext.jar", "/path/to/save/encrypted.jar", xKey, XConstants.MODE_DANGER);*/


        // Spring-Boot Jar包解密
        /*String password = "io.xjar";
        XKey xKey = XKit.key(password);
        XBoot.decrypt("/path/to/read/encrypted.jar", "/path/to/save/decrypted.jar", xKey);*/


        // Jar包加密
        /*String password = "io.xjar";
        XKey xKey = XKit.key(password);
        XJar.encrypt("/path/to/read/plaintext.jar", "/path/to/save/encrypted.jar", xKey);*/


        // 危险加密模式，即不需要输入密码即可启动的加密方式，这种方式META-INF/MANIFEST.MF中会保留密钥，请谨慎使用！
        /*String password = "io.xjar";
        XKey xKey = XKit.key(password);
        XJar.encrypt("/path/to/read/plaintext.jar", "/path/to/save/encrypted.jar", xKey, XConstants.MODE_DANGER);*/


        // Jar包解密
        /*String password = "io.xjar";
        XKey xKey = XKit.key(password);
        XJar.decrypt("/path/to/read/encrypted.jar", "/path/to/save/decrypted.jar", xKey);*/


        // Spring-Boot Jar包加密
        XKey xKey = XKit.key(PASSWORD);
        XJar.encrypt(JAR_ORIGIN, TARGET, xKey, new XEntryFilter<JarArchiveEntry>() {
            @Override
            public boolean filtrate(JarArchiveEntry entry) {
                //可设置哪些不加密
                /*return entry.getName().startsWith("/BOOT-INF/classes/")
                        || entry.getName().startsWith("/BOOT-INF/lib/jar-need-encrypted");*/
                return false;
            }
        });
    }
}
