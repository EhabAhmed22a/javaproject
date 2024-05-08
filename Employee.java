package javaapplication4;


abstract public class Employee {
	
	private String name;
	private int age;
	private int salary;
	
	Employee(String name , int age , int salary){
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	
	//----------------------------------------------------//
	
	public int getSalary() {return this.salary;}

	public void changeSalary(int newSalary) {
		this.salary = newSalary;
	}
	
	//----------------------------------------------------//

}
