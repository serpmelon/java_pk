package com.togo.java.bytecode;

import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;


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
 * @date Created in 2019年07月25日 18:03
 * @since 1.0
 */
public class ThreadCW {

    public static byte[] test() {ClassWriter cw = new ClassWriter(0);
        FieldVisitor fv;
        MethodVisitor mv;
        AnnotationVisitor av0;

        cw.visit(52, ACC_PUBLIC + ACC_SUPER, "com/togo/java/bytecode/TestThread", null, "java/lang/Object", new String[]{"java/lang/Runnable"});

        cw.visitSource("TestThread.java", null);

        {
            fv = cw.visitField(ACC_PRIVATE, "count", "I", null, null);
            fv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            mv.visitLabel(l0);
            mv.visitLineNumber(17, l0);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            Label l1 = new Label();
            mv.visitLabel(l1);
            mv.visitLineNumber(19, l1);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitIntInsn(BIPUSH, 10);
            mv.visitFieldInsn(PUTFIELD, "com/togo/java/bytecode/TestThread", "count", "I");
            mv.visitInsn(RETURN);
            Label l2 = new Label();
            mv.visitLabel(l2);
            mv.visitLocalVariable("this", "Lcom/togo/java/bytecode/TestThread;", null, l0, l2, 0);
            mv.visitMaxs(2, 1);
            mv.visitEnd();
        }
        {
            mv = cw.visitMethod(ACC_PUBLIC, "run", "()V", null, null);
            mv.visitCode();
            Label l0 = new Label();
            Label l1 = new Label();
            Label l2 = new Label();
            mv.visitTryCatchBlock(l0, l1, l2, "java/lang/InterruptedException");
            Label l3 = new Label();
            mv.visitLabel(l3);
            mv.visitLineNumber(24, l3);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitFieldInsn(GETFIELD, "com/togo/java/bytecode/TestThread", "count", "I");
            mv.visitIntInsn(BIPUSH, 10);
            Label l4 = new Label();
            mv.visitJumpInsn(IF_ICMPNE, l4);
            mv.visitLabel(l0);
            mv.visitLineNumber(27, l0);
            mv.visitLdcInsn(new Long(2000L));
            mv.visitMethodInsn(INVOKESTATIC, "java/lang/Thread", "sleep", "(J)V", false);
            mv.visitLabel(l1);
            mv.visitLineNumber(30, l1);
            Label l5 = new Label();
            mv.visitJumpInsn(GOTO, l5);
            mv.visitLabel(l2);
            mv.visitLineNumber(28, l2);
            mv.visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[]{"java/lang/InterruptedException"});
            mv.visitVarInsn(ASTORE, 1);
            Label l6 = new Label();
            mv.visitLabel(l6);
            mv.visitLineNumber(29, l6);
            mv.visitVarInsn(ALOAD, 1);
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/lang/InterruptedException", "printStackTrace", "()V", false);
            mv.visitLabel(l5);
            mv.visitLineNumber(31, l5);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            mv.visitLdcInsn("haha");
            mv.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
            Label l7 = new Label();
            mv.visitLabel(l7);
            mv.visitLineNumber(32, l7);
            mv.visitVarInsn(ALOAD, 0);
            mv.visitInsn(ICONST_1);
            mv.visitFieldInsn(PUTFIELD, "com/togo/java/bytecode/TestThread", "count", "I");
            mv.visitJumpInsn(GOTO, l3);
            mv.visitLabel(l4);
            mv.visitLineNumber(34, l4);
            mv.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
            mv.visitInsn(RETURN);
            Label l8 = new Label();
            mv.visitLabel(l8);
            mv.visitLocalVariable("e", "Ljava/lang/InterruptedException;", null, l6, l5, 1);
            mv.visitLocalVariable("this", "Lcom/togo/java/bytecode/TestThread;", null, l3, l8, 0);
            mv.visitMaxs(2, 2);
            mv.visitEnd();
        }
        cw.visitEnd();

        return cw.toByteArray();
    }

    public Class build(String className) {

        MyClassLoader loader = new MyClassLoader();
        return loader.defineClass(className, test());
    }

    class MyClassLoader extends ClassLoader {
        public Class defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }
}