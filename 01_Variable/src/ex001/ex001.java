package ex001;

public class ex001 {
	
	public static void ex001() {
		double a = 5.0;
		double b = 2.0;
		
		double temp;
		
		temp = a;
		a = b;
		b = temp;
		System.out.println(a);
		System.out.println(b);
		
	}

	public static void main(String[] args) {
		ex001();
	}

}
