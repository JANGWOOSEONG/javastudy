package ex02_loop;

public class Ex01_for {
	
	public static void ex01() {
			//1~10
		
			/*for 문

			연속된 숫자를 생성하는 반복문 (배열에서 주로 사용)
			형식 
			for문 초기문 조건문 증감문 {실행문
			*/
		
		for(int a = 1; a <= 10; a++) {
			 System.out.println(a);
		}
	}
	public static void ex02() {
		//0부터 시작하는걸 선호
		//횟수
		int count = 5;
		
		for(int a = 0; a < count; a++) {
			System.out.println("Hello Wrold");
		}
	}
	
	public static void ex03() {
		// 10 ~ 1
		
		for(int a = 10; a >= 1; a--) {
			System.out.println(a);
		}
	}
	
	public static void ex04() {
		// 연습
		// 구구단 2단 출력
		// 2 x 1 = 2
		
		int dan = 5;  // 이 곳에 원하는 구구단을 넣으면 된다.
		
		for(int a = 1; a <= 9; a++) {
			System.out.println(dan + " x " + a + " = " + (dan * a));
		}
		
	}

	public static void main(String[] args) {
		ex04();

	}

}
