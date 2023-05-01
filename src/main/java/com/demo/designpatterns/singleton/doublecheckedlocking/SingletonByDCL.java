/*
 * Singleton By Double-Checked Locking
 * If you notice carefully once an object is created,
 * synchronization is no longer useful because now singletonInstance will not be null
 * and any sequence of operations will lead to consistent results.
 * So we will only acquire lock on the getInstance() once,
 * when the singletonInstance is null.
 * This way we only synchronize the first way through, just what we want.
 * We have declared the singletonInstance volatile which ensures that multiple threads
 * offer the singletonInstance variable correctly when it is being initialized
 * to Singleton instance.
 * This method drastically reduces the overhead of calling
 * the synchronized method every time.
 */
package com.demo.designpatterns.singleton.doublecheckedlocking;

public class SingletonByDCL {
  private static volatile  SingletonByDCL singletonInstance;
  private SingletonByDCL() {}

  public static SingletonByDCL getSingletonInstance() {
    if(singletonInstance == null) {
      synchronized (SingletonByDCL.class) {
        if(singletonInstance == null)
          singletonInstance = new SingletonByDCL();
      }
    }
    return singletonInstance;
  }
}
