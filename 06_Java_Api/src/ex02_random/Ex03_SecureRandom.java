package ex02_random;

import java.security.SecureRandom;

public class Ex03_SecureRandom {

	public static void main(String[] args) {

		// java.security.SucureRandom
		
		SecureRandom secureRandom = new SecureRandom();
		
		// 정수 난수
		int dice =  secureRandom.nextInt(6) + 1; // 1~6 주사위
				System.out.println(dice);
	}

}
