package org.graalvm.example;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.matcher.ElementMatchers;
import org.graalvm.example.nativeimage.meta.Constant;

import java.lang.reflect.InvocationTargetException;

public class ByteBuddyClassCreator {

    @Constant
    public static Class<?> createByteBuddyClass(String message) {
        return new ByteBuddy().subclass(Object.class).method(ElementMatchers.named("toString")).intercept(FixedValue.value(message)).make().load(ByteBuddyClassCreator.class.getClassLoader()).getLoaded();
    }

    static {
        System.out.println("Hello from the ByteBuddy class creator!");
    }

}
