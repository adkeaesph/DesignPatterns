package com.demo.designpatterns.singleton.testsingleton;

import java.io.Serial;
import java.io.Serializable;

public class BestSingleton implements Serializable, Cloneable {
  private static volatile BestSingleton singletonInstance;

  private BestSingleton() throws IllegalAccessException {
    if(singletonInstance != null)
      throw new IllegalAccessException("Constructor usage not allowed");
  }

  public static BestSingleton getSingletonInstance() throws IllegalAccessException {
    if(singletonInstance == null) {
      synchronized (BestSingleton.class) {
        if(singletonInstance == null)
          singletonInstance = new BestSingleton();
      }
    }
    return singletonInstance;
  }

  @Override
  protected BestSingleton clone() throws CloneNotSupportedException {
    throw new CloneNotSupportedException("Cloning not allowed for singleton class");
  }

  @Serial
  protected Object readResolve() { return singletonInstance; }
}
