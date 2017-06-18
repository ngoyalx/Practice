package Xebia.SampleMavenProject;

public class Threadlocaltest implements Runnable {
	
	 private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
	 

      @Override
      public void run() {
          threadLocal.set( (int) (Math.random() * 100D) );
  
          try {
              Thread.sleep(2000);
          } catch (InterruptedException e) {
          }
  
          System.out.println(threadLocal.get());
      }
  


  public static void main(String[] args) throws InterruptedException {
	  Threadlocaltest sharedRunnableInstance = new Threadlocaltest();
	  threadLocal.set(2);
      Thread thread1 = new Thread(sharedRunnableInstance);
      Thread thread2 = new Thread(sharedRunnableInstance);

      thread1.start();
      thread2.start();

      thread1.join(); //wait for thread 1 to terminate
      thread2.join(); //wait for thread 2 to terminate
      
      System.out.println(threadLocal.get());
  }

}
