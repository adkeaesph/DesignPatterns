package com.demo.designpatterns.singleton.testsingleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingletonSuccess {
  public static void main(String[] args) throws
      CloneNotSupportedException, IOException, ClassNotFoundException,
      InvocationTargetException, InstantiationException, IllegalAccessException {
    //Reflection
    System.out.println("Reflection Testing for DCL Singleton");

    Class<BestSingleton> bestSingletonClass = BestSingleton.class;
    Constructor<?> constructor = bestSingletonClass.getDeclaredConstructors()[0];
    constructor.setAccessible(true);
    BestSingleton singleton2 = (BestSingleton) constructor.newInstance();
    BestSingleton singleton = BestSingleton.getSingletonInstance();
    if(!singleton.equals(singleton2)) {
      System.out.println("One more instance of singleton class got created");
      System.out.println("Hashcode of original instance: "+singleton.hashCode());
      System.out.println("Hashcode of new instance: "+singleton2.hashCode());
    }

    //(De)Serialisation
    System.out.println("\n(De)Serialisation Testing for DCL Singleton");
    ObjectOutput out = new ObjectOutputStream(
        new FileOutputStream("file.txt"));
    out.writeObject(singleton);
    out.close();

    // deserialize from file to object
    ObjectInput in = new ObjectInputStream(
        new FileInputStream("file.txt"));

    BestSingleton singleton3
        = (BestSingleton)in.readObject();
    in.close();
    if(singleton.equals(singleton3)) {
      System.out.println("No new instance of enum singleton class got created");
      System.out.println("Hashcode of original instance: "+singleton.hashCode());
      System.out.println("Hashcode of de-serialised instance: "+singleton3.hashCode());
    }

    //Cloning
    System.out.println("\nCloning Testing for DCL Singleton");
    BestSingleton singleton4 = singleton.clone();
    if(singleton.equals(singleton4)) {
      System.out.println("No new instance of enum singleton class got created");
      System.out.println("Hashcode of original instance: "+singleton.hashCode());
      System.out.println("Hashcode of de-serialised instance: "+singleton4.hashCode());
    }
  }
}
