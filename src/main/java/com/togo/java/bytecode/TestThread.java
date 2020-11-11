package com.togo.java.bytecode;

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
 * @date Created in 2019年07月25日 17:52
 * @since 1.0
 */
public class TestThread implements Runnable {

    private int count = 10;

    @Override
    public void run() {

        while(count == 10){

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("haha");
            count = 1;
        }
    }
}