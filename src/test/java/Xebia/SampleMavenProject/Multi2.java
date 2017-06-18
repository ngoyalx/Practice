package Xebia.SampleMavenProject;

public class Multi2 implements Runnable {

	public static void main(String[] args) {
		Multi2 m1=new Multi2();
		Multi2 m2=new Multi2();
		Thread t1=new Thread(m1);
		Thread t2=new Thread(m2);
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		//t2.start();
		t1.start();
		t1.run();
		System.out.println(t1.getState());
		//t1.start();
		System.out.println(t1.isAlive());
		System.out.println(t2.isAlive());
		System.out.println(t1.getName());
		System.out.println(t2.getName());
		//t1.setPriority(1);
		//t2.setPriority(2);
	}

	@Override
	public void run() {
	
		System.out.println("Thread is running  " + Thread.currentThread().getName() );
		
	}

}
