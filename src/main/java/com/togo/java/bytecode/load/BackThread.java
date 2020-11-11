package com.togo.java.bytecode.load;

import com.togo.java.bytecode.ThreadCW;

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
 * @date Created in 2019年07月25日 18:54
 * @since 1.0
 */
public class BackThread implements Runnable {

    @Override
    public void run() {

        while (true) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
    }
}