/*
 * Singleton By Eager Instantiation
 * Here we have created instance of singleton in static initializer.
 * JVM executes static initializer when the class is loaded and
 * hence, this is guaranteed to be thread safe.
 * Use this method only when your singleton class is light and
 * is used throughout the execution of your program.
 */
package com.demo.designpatterns.singleton.earlyinstantiation;

public class SingletonByEI {
  private static final SingletonByEI singletonInstance = new SingletonByEI();

  private SingletonByEI() {}

  public static SingletonByEI getInstance() {
    return singletonInstance;
  }
}
