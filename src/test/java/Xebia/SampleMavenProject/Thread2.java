package Xebia.SampleMavenProject;

public class Thread2 extends Thread {

	@Override
	public void run(){
		for(int i=500;i<1000;i++){
			System.out.println(i);
		}
	}
}
