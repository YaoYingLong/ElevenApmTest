package com.icode.eleven.transformer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

/**
 * @author by YingLong on 2024/10/28
 */
public class DefineTransformer  implements ClassFileTransformer {

    public static final String TRANSFORM_CLASS = "com.icode.eleven.controller";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className == null || className.equals("")) {
            return null;
        }
        try {
            className = className.replace("/", ".");
            if (className.startsWith(TRANSFORM_CLASS)) {
                final ClassPool classPool = ClassPool.getDefault();
                final CtClass clazz = classPool.get(className);

                for (CtMethod method : clazz.getMethods()) {
                    if (Modifier.isNative(method.getModifiers())) {
                        continue;
                    }
                    method.insertBefore("System.out.println(\"" + clazz.getSimpleName() + "." + method.getName() + " start.\");");
                    method.insertAfter("System.out.println(\"" + clazz.getSimpleName() + "." + method.getName() + " end.\");", false);
                }
                return clazz.toBytecode();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
