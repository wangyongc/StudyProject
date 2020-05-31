package com.example.buildsrcnew;

import groovyjarjarasm.asm.MethodVisitor;
import groovyjarjarasm.asm.Opcodes;

public class LifecycleMethodVisitor extends MethodVisitor {

    private static final String TAG = "LifecycleMethodVisitor";

    private String className,methodName;

    public LifecycleMethodVisitor(MethodVisitor methodVisitor,String className,String methodName) {
        super(Opcodes.ASM5, methodVisitor);

        this.className = className;
        this.methodName = methodName;
    }

    @Override
    public void visitCode() {
        super.visitCode();

        System.out.println(TAG+"===== visitCode() ======");

        mv.visitLdcInsn("TAG");
        mv.visitLdcInsn(className + " ----> "+methodName);
        mv.visitMethodInsn(Opcodes.INVOKESTATIC,"android/util/Log","i","(Ljava/lang/String;Ljava/lang/String;)I",false);
        mv.visitInsn(Opcodes.POP);
    }
}