package com.java8.main;


import com.java8.interfaces.Demo;

public class Lambda {
    public static void main(String[] args){
        Demo demo = str->str.length();
        System.out.println("Length of string is :"+demo.getStringLength("Pankaj Singh Negi"));
        demo.defaultMethod();
        Demo.staticMethod();
    }
}
