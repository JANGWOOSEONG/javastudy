package ex04_OutPutStream;

import java.io.Serializable;

/*
    ObjectOutPutStream/ObjectInPutStream을 통해서
    객체 입출력을 수행하려면 "반드시" 직렬화 처리를 해야한다.
*/
/*
    직렬화 처리 방법
    1. java.io.Serializable 인터페이스를 구현(implements)한다.
    2. SerialVesionUID 필드 값을 정의한다.
*/



public class Person implements Serializable {
	
	private static final long serialVersionUID = 4479216247332307844L;
	private String name;
	private int age;
	private double height;
	private boolean isAlive;
	
	public Person() {
	}

	public Person(String name, int age, double height, boolean isAlive) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.isAlive = isAlive;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height + ", isAlive=" + isAlive + "]";
	}

}
