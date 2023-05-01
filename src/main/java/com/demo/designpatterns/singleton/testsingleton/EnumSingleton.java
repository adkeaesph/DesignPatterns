/*
 * Singleton by Enum
 * Thread-safe, safety from (de)serialisation, reflection and cloning
 */
package com.demo.designpatterns.singleton.testsingleton;

public enum EnumSingleton implements Cloneable{
  INSTANCE
}
