package Xebia.SampleMavenProject;

public class MultiThreading {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Thread1 t1 = new Thread1();
		Thread2 t2 = new Thread2();
		t1.start();
		System.out.println(t1.getName());
		t2.start();
		System.out.println(t2.getName());

	}

}
