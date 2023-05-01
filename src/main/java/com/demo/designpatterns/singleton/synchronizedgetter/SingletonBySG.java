/*
 * Singleton by synchronized getter (getInstance() method)
 * Here using synchronized makes sure that only one thread
 * at a time can execute getInstance().
 * The main disadvantage of this is method is that using synchronized
 * every time while creating the singleton object is expensive
 * and may decrease the performance of your program.
 * However, if performance of getInstance() is not critical for your application
 * this alternative provides a clean and simple solution.
 */
package com.demo.designpatterns.singleton.synchronizedgetter;

public class SingletonBySG {
  private static SingletonBySG singletonInstance = null;

  private SingletonBySG() {}

  public static synchronized SingletonBySG getSingletonInstance() {
    if(singletonInstance == null)
      singletonInstance = new SingletonBySG();
    return singletonInstance;
  }
}
