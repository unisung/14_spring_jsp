package absAndInterface;

public class myMain {

	public static void main(String[] args) {
		//선언
		MyFunInter m1 =new MyFunInter() {
			@Override
			public void m1() {
				System.out.println("인터메소드");
				
			}
		};
		
		MyFunInter m2 = new MyClass();
      //사용
		m1.m1();
		//람다식 -전제조건 - 추상메소드가 하나만 존재해야함.
		MyFunInter m3 = () ->	System.out.println("인터메소드");
		
	  m3.m1();
	}

}
