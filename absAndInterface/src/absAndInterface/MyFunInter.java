package absAndInterface;

@FunctionalInterface//(함수적인터페이스)
//추상메소드가 1개인 인터페이스
//람다식을 만들기 위한 조건
public interface MyFunInter {
	final int a=10; //static필드(상수)
	public  abstract void m1();
    //public  abstract void m2();
}

class MyClass implements MyFunInter{
	@Override
	public void m1() {
		System.out.println("인터메소드");
	}


}

class B{
	int b;//필드(변수)
	void m2() {
		b=10;
	}
	void m3() {
		b=20;
	}
}
