package com.togo.java.bytecode.load;

import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>    修改记录
 * <BR>-----------------------------------------------
 * <BR>    修改日期         修改人          修改内容
 * </PRE>
 *
 * @author taiyn
 * @version 1.0
 * @date Created in 2019年07月25日 18:53
 * @since 1.0
 */
public class Main {

    private static String path = Main.class.getResource("/").getPath();

    public static void main(String[] args) throws Exception {


        System.out.println(path);
        while (true) {

            URL[] urls = new URL[1];
            urls[0] = new URL("file", null, path);
//            MyClassLoader loader = new MyClassLoader(urls);

            MyClassLoader loader = new MyClassLoader(
                    path, new String[] { "com.togo.java.bytecode.load.Peo" });

            Class klass = loader.loadClass("com.togo.java.bytecode.load.Peo");
//            Class klass = loader.loadClass("Peo");
            Method method = klass.getMethod("print", null);
            Object a = klass.newInstance();
            Object obj = method.invoke(a, null);

            System.out.println(obj);
//            loader = null;
//            klass = null;
//            a = null;
//            method = null;
//            System.gc();
            Thread.sleep(2000);
        }
    }
}