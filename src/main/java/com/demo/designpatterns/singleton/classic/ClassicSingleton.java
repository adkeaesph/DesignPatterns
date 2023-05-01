/*
 * Here we have declared getInstance() static so that we can call it
 * without instantiating the class. The first time getInstance() is called
 * it creates a new singleton object and after that it just returns the same object.
 * Note that Singleton obj is not created until we need it and call getInstance() method.
 * This is called lazy instantiation.
 * The main problem with above method is that it is not thread safe.
 */
package com.demo.designpatterns.singleton.classic;

public class ClassicSingleton {
  private static ClassicSingleton singletonInstance = null;

  private ClassicSingleton() {};

  public static ClassicSingleton getSingletonInstance() {
    if(singletonInstance == null)
      singletonInstance = new ClassicSingleton();
    return singletonInstance;
  }
}
