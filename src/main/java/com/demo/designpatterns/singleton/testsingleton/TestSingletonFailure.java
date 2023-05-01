package com.demo.designpatterns.singleton.testsingleton;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingletonFailure {
  public static void main(String[] args) throws InvocationTargetException,
      InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
    //Reflection
    System.out.println("Reflection Testing for DCL Singleton");
    SingletonByDCL singleton = SingletonByDCL.getSingletonInstance();
    Class<SingletonByDCL> dclClass = SingletonByDCL.class;
    Constructor<?> constructor = dclClass.getDeclaredConstructors()[0];
    constructor.setAccessible(true);
    SingletonByDCL singleton2 = (SingletonByDCL) constructor.newInstance();
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

    SingletonByDCL singleton3
        = (SingletonByDCL)in.readObject();
    in.close();
    if(!singleton.equals(singleton3)) {
      System.out.println("One more instance of singleton class got created");
      System.out.println("Hashcode of original instance: "+singleton.hashCode());
      System.out.println("Hashcode of new instance: "+singleton3.hashCode());
    }

    //Cloning
    System.out.println("\nCloning Testing for DCL Singleton");
    SingletonByDCL singleton4 = singleton.clone();
    if(!singleton.equals(singleton4)) {
      System.out.println("One more instance of singleton class got created");
      System.out.println("Hashcode of original instance: "+singleton.hashCode());
      System.out.println("Hashcode of new instance: "+singleton4.hashCode());
    }

    //Reflection
    System.out.println("\nReflection Testing for Enum Singleton");
    System.out.println("Enum objects cannot be created reflectively");

    //(De)Serialisation
    System.out.println("\n(De)Serialisation Testing for Enum Singleton");
    EnumSingleton singleton5 = EnumSingleton.INSTANCE;
    out = new ObjectOutputStream(
        new FileOutputStream("file2.txt"));
    out.writeObject(singleton5);
    out.close();

    // deserialize from file to object
    in = new ObjectInputStream(
        new FileInputStream("file2.txt"));

    EnumSingleton singleton6
        = (EnumSingleton)in.readObject();
    in.close();
    if(singleton5.equals(singleton6)) {
      System.out.println("No new instance of enum singleton class got created");
      System.out.println("Hashcode of original instance: "+singleton5.hashCode());
      System.out.println("Hashcode of de-serialised instance: "+singleton6.hashCode());
    }

    //Cloning
    System.out.println("\nCloning Testing for Enum Singleton");
    System.out.println("Enum objects cannot be cloned");
  }
}
