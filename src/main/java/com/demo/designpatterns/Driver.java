package com.demo.designpatterns;

import com.demo.designpatterns.singleton.SingletonByEI;

public class Driver {
    public static void main(String[] args) {
        SingletonByEI singletonInstance1 = SingletonByEI.getInstance();
        SingletonByEI singletonInstance2 = SingletonByEI.getInstance();
        if(singletonInstance1.equals(singletonInstance2))
            System.out.println("Singleton instances are the same object. " +
                "This is known during compile-time only");
        else {
            System.out.println("unreachable code");
        }
    }
}
