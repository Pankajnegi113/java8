package com.java8.interfaces;

@FunctionalInterface
public interface Demo{
    int getStringLength(String str);

    default void defaultMethod(){
        System.out.println("This is default method of Demo interface");
    }

    static void staticMethod(){
        System.out.println("This is static method of Demo interface");
    }
}
