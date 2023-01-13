package practice02_Person_Array;

public class Person {
	
	//필드
	private String name;
	private int age;
	
	//생성자 (디폴트 생성자는 생성자가 하나도 안 만들어져있을때 사용이 가능) (생성자를 하나라도 만들면 자동으로 만들어져서 사용되지 않는다)
	public Person() {}  // new Person
	public Person(String name, int age) { // new Person("alice", 20)
		this.name = name;
		this.age = age;
	}
	// 메소드
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

	

}
