import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyExam {
public static void main(String[] args) {
	Set<Integer> set = new HashSet<>();
	set.add(new Integer("1"));
	set.add(2);
	set.add(Integer.valueOf(3));
	set.add(4);
	
	System.out.println(set);
	
	Iterator<Integer> itor = set.iterator();
	while(itor.hasNext()) {
		System.out.println(itor.next());
	}
	
	Object[] objs = {new A(), new B(), new B()};
	
	A a = new A();
	A b = new A();
	
	System.out.print(a.hashCode()==b.hashCode());
	System.out.println(System.identityHashCode(a)
			 == System.identityHashCode(b));
	
  }
}

class A extends Object{}
class B extends Object{}
