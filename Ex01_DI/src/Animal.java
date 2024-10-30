
public class Animal {
  void run() {
	  System.out.println("달린다");
  }
  public static void main(String[] args) {
	Animal[] animals 
	  = {new Dog(),new Bird(), new Fish()};
	
	for(Animal animal: animals ) {
		animal.run();
	}
}
}
class Dog extends Animal{
	@Override
	void run() {
		System.out.println("네발로 달린다.");
	} }
class Bird extends Animal{

	@Override
	void run() {
		System.out.println("날아간다");
	}}
class Fish extends Animal{
	@Override
	void run() {
		System.out.println("헤엄친다");
	}}