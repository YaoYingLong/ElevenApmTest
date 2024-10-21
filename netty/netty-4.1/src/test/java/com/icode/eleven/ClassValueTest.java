package com.icode.eleven;

import com.icode.eleven.config.NettyServerHandler;
import io.netty.bootstrap.Bootstrap;
import io.netty.util.concurrent.GenericFutureListener;
import org.junit.jupiter.api.Test;

/**
 * @author by YingLong on 2024/10/21
 */
public class ClassValueTest {
    private static final ClassValue<Boolean> shouldWrap = new ClassValue<Boolean>() {
        @Override
        protected Boolean computeValue(Class<?> type) {
            // we only want to wrap user callbacks
            String className = type.getName();
            return !className.startsWith("io.opentelemetry.javaagent.") && !className.startsWith("io.netty.");
        }
    };

    @Test
    public void test() {
        System.out.println("ClassValueTest.test===" + shouldWrap.get(GenericFutureListener.class));
    }

}
