package com.demo.designpatterns.singleton.classic;

import java.util.ArrayList;
import java.util.List;

public class Driver {
  public static List<Thread> getThreadList(int n) {
    List<Thread> threadList = new ArrayList<>();
    for(int i=0; i<n; i++) {
      Thread thread = new Thread(){
        @Override
        public void run() {
          super.run();
          System.out.println(ClassicSingleton.getSingletonInstance().hashCode());
        }
      };
      threadList.add(thread);
    }
    return threadList;
  }
  public static void main(String[] args) {
//    ClassicSingleton singletonInstance1 = ClassicSingleton.getSingletonInstance();
//    ClassicSingleton singletonInstance2 = ClassicSingleton.getSingletonInstance();
//    if(singletonInstance1.equals(singletonInstance2)) {
//      System.out.println("Singleton instances are the very same object " +
//          "when called by a single thread");
//    } else {
//      System.out.println("unreachable code");
//    }

    // Need to run the below snippet multiple times,
    // to see the threads trying to access the singleton instance simultaneously.
    List<Thread> threadList = getThreadList(2);
    threadList.parallelStream().forEach(Thread::start);
  }
}
