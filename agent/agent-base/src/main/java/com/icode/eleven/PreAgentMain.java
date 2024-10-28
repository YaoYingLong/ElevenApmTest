package com.icode.eleven;

import com.icode.eleven.transformer.DefineTransformer;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

/**
 * @author by YingLong on 2024/10/18
 */
public class PreAgentMain {
    public static void premain(String args, Instrumentation instrumentation) {
        System.out.println("premain start!");
        instrumentation.addTransformer(new DefineTransformer());
        System.out.println("premain end!");
    }

    public static void agentmain(String args, Instrumentation instrumentation) {
        System.out.println("agentmain start!");
        instrumentation.addTransformer(new DefineTransformer());
        System.out.println("agentmain end!");
    }
}