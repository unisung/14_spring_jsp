
public abstract class Attendance {
	double balance;
	double salary;
	
	public String getInfo(String name) {
		return name;
	}
	abstract void calcSal(int empno);

	public static void main(String[] args) {
		//Attendance a = new Attendance();
	}
}
class Acc extends Attendance{

	@Override
	void calcSal(int empno) {
		// TODO Auto-generated method stub
		
	}}
class Sales extends Attendance{

	@Override
	void calcSal(int empno) {
		// TODO Auto-generated method stub
		
	}}
class Manage extends Attendance{

	@Override
	void calcSal(int empno) {
		// TODO Auto-generated method stub
		
	}}