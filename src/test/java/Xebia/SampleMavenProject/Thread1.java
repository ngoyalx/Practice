package Xebia.SampleMavenProject;

public class Thread1 extends Thread {

	@Override
	public void run(){
		for(int i=0;i<500;i++){
			System.out.println(i);
		}
	}
}
