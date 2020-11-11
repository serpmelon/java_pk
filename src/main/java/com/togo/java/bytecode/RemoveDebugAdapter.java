package com.togo.java.bytecode;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;

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
 * @date Created in 2019年07月25日 17:30
 * @since 1.0
 */
public class RemoveDebugAdapter extends ClassVisitor {

    public RemoveDebugAdapter(ClassVisitor classVisitor) {
        super(Opcodes.ASM4, classVisitor);
    }
}