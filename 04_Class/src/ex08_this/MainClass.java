package ex08_this;

public class MainClass {

	public static void main(String[] args) {
		
		//User 객체 생성
		User user = new User("admin", "123456");
		
		//user에 저장된 값은 생성된 user 객체의
		System.out.println(user);
		
		// user 객체의 this 값 확인
		user.printThis();

	}

}
