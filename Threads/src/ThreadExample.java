
public class ThreadExample {

	public static void main(String[] args) {
		System.out.println("Main Starts!!!");
		
		NumberThread t1 = new NumberThread(1, 400);
		NumberThread t2 = new NumberThread(801, 1200);
		
		t1.start();
		t2.start();
		
		doTask();
		System.out.println("Main Dies!!!");

	}

	private static void doTask() {
		Thread t = Thread.currentThread();
		System.out.println("Name: " + t.getName());
		System.out.println("Group: " + t.getThreadGroup().getName());
		System.out.println("Priority: " + t.getPriority());
		/*
		 * JRE checks the status of only non-daemon threads before it terminates
		 */
		System.out.println("Daemon: " + t.isDaemon());
	}

}
