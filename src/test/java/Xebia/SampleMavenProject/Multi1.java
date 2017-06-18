package Xebia.SampleMavenProject;

public class Multi1 extends Thread {

	public void run(){
		
		try {
			Thread.sleep(5000);
			System.out.println("Thread is running");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		Multi1 t1=new Multi1();
		System.out.println(t1.isAlive());
		System.out.println(t1.isDaemon());
		System.out.println(t1.getState());
		t1.start();
		System.out.println(t1.getState());
		Thread.sleep(2000);
		System.out.println(t1.isAlive());
		System.out.println(t1.getState());


	}

}
