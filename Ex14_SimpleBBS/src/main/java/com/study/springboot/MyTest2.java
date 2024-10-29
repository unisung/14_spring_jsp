package com.study.springboot;

public class MyTest2 {
  void m1() {}
  void m1(int a) {}
  void m1(int a,int b) {}
  
  public static void main(String[] args) {
	MyTest2 t2 = new MyChild();
	t2.m1();
}
}

class MyChild extends MyTest2{
	void m1() {}
}