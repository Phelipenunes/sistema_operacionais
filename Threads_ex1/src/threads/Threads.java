package threads;

public class Threads extends Thread {
	public void run(){
		long id = this.threadId();
		System.out.println("#:"+id);
	}
}
