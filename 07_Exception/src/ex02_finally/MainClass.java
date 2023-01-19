package ex02_finally;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		//finally 블록
		// 항상 마지막에 실행되는 블록으로 생략할 수 있다.
		//선언
		Scanner sc = null;
		//생성
		try {
		sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요 >>> ");
		int age = sc.nextInt();
		System.out.println(age >= 20 ? "주료 구매가 가능합니다" : "주류 구매가 불가능합니다.");
		} catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
		} finally {
			sc.close(); //finally 블록은 자원(resource)을 반납할 때 주로 사용한다.
			
			
		}

	}

}
