package com.demo.designpatterns.singleton.doublecheckedlocking;

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
          System.out.println(SingletonByDCL.getSingletonInstance().hashCode());
        }
      };
      threadList.add(thread);
    }
    return threadList;
  }
  public static void main(String[] args) {

    // No matter how many times the below snippet is run,
    // the same singleton instance is returned.
    List<Thread> threadList = getThreadList(2);
    threadList.parallelStream().forEach(Thread::start);
  }
}
