package absAndInterface;

public  abstract class MyAbsClass {
	public abstract void m1();
	public void mym2() {
		System.out.println("일반메소드");
	}
	public static void main(String[] args) {
		MyAbsClass a = new MyAbs3();
	}
}

abstract class MyAbs2 extends MyAbsClass{
	public void mym2() {
		System.out.println("일반메소드");
	}
}

class MyAbs3 extends MyAbs2{

	@Override
	public void m1() {	}
	
}




