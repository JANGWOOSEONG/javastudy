package ex01_variable;

public class MainClass {


	public static void main(String[] args) {

		
		boolean isGood = true;
		boolean isAlive = false;
		System.out.println(isGood);
		System.out.println(isAlive);

		// 문자 타입(Character) : 1글자
		char ch1 = 'A';
		char ch2 = '홍';
		char ch3 = '\n';		// 라인 피드 - 줄 바꿈
		char ch4 = '\t';		// 탭
		char ch5 = '\'';		//작은 따옴표
		char ch6 = '\"';		//큰 따옴표
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		//정수타입
		int age = 46;
		long money = 10000000000L;
		System.out.println(age);
		System.out.println(money);
		
		// 정수 구분의 기준
		System.out.println(Integer.MAX_VALUE);
		
		// 실수 타입
		double leftEye = 0.7;
		double rightEye = 1.2;
		System.out.println(leftEye);
		System.out.println(rightEye);
		
		// 문자열 타입 (여러 글자를 의미, 글자 수의 제한이 없음)
		String name = "장우성";	// java에서 기본 타입과 같은 사용법을 제공
		System.out.println(name);
		String country = new String("Korea");
		System.out.println(country);
		
		// 상수 선언하기 (final 키워드가 필요)
		final double PI = 3.141592;
		System.out.println(PI);
		
	}
}