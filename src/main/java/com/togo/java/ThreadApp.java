package com.togo.java;

import com.togo.java.bytecode.TestThread;
import com.togo.java.bytecode.ThreadCW;

import java.lang.reflect.Method;

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
 * @date Created in 2019年07月25日 17:57
 * @since 1.0
 */
public class ThreadApp {

    public static void main(String[] args) throws Exception {

        TestThread tt = new TestThread();
        Thread thread = new Thread(tt);
        thread.start();


        ThreadCW tcw = new ThreadCW();
        Class<?> clazz = tcw.build("com.togo.java.bytecode.TestThread");//cl.defineClass("com.togo.java.bytecode.People", cb.build());
        // 反射获取 main 方法
//        Method main = clazz.getMethod("test", String.class);
//        // 调用 main 方法
//        main.invoke(clazz.newInstance(), "qqq");
    }
}