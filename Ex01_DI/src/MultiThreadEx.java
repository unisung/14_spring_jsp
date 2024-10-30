
public class MultiThreadEx {
	public static void main(String[] args) {
		 Thread subTask1 = new Run1();
	     Thread subTask2 = new Run2();
	     
	        subTask1.start();
	        subTask2.start();
	}
}
