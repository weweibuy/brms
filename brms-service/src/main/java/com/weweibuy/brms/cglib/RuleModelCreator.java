package com.weweibuy.brms.cglib;

import org.springframework.asm.ClassWriter;
import org.springframework.asm.Opcodes;
import org.springframework.cglib.beans.BeanGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;


/**
 * @author durenhao
 * @date 2021/9/20 18:08
 **/
public class RuleModelCreator {


    public static void main(String[] args) throws Exception {
        BeanGenerator beanGenerator = new BeanGenerator();
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(Opcodes.V1_8, Opcodes.ACC_PUBLIC, "clazz/User", null,
                "java/lang/Object", null);
        classWriter.visitEnd();


        beanGenerator.generateClass(classWriter);
        Object o = beanGenerator.create();
        System.err.println(o);
        System.err.println(o.getClass());
        Method[] declaredMethods = o.getClass().getDeclaredMethods();
        Arrays.stream(declaredMethods)
                .forEach(m -> System.err.println(m.getName()));
        ;

    }


}
