
public class Test {
  static int a;
  int b; 
  
  static void m1() {
	  a=10;
  }
  
   final void m2() {}
         void m3() {}
}
//Plain Old Java Object
class Child extends Test{

	@Override
	void m3() {
		// TODO Auto-generated method stub
		super.m3();
	}

}
