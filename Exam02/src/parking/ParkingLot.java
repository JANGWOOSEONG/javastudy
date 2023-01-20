package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	public ParkingLot(String name) {
		this.name = name;
		
		
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	public void addCar() {
		
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if (idx == cars.length) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return; 
		}
		System.out.println("차량번호 >>> ");
		String carNo = sc.next();
		System.out.println("모델 >>> ");
		String model = sc.next();
		
		cars[idx++] = new Car(carNo, model);
		System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
	}
	
	public void deleteCar() {
		
		if(idx == 0 ) {
			System.out.println("등록된 차량이 없습니다.");
			return;
			}
			System.out.println("제거할 차량번호 >>> ");
			String delcarNo = sc.next();
			for(int i = 0; i < idx; i++) {
				Car car = cars[i];
				if(delcarNo.equals(car.getCarNo())) {
					
					System.arraycopy(cars, i + 1, cars, i, idx - i - 1);
					cars[--idx] = null;
					System.out.println("차량번호 " + delcarNo + "인 차량이 삭제되었습니다");
					return;
					
					/*
					 마지막 차량을 옮겨오기
					 제거할 차량의 위치 : i
					 마지막 차량의 위치 : idx -1
					cars[i] = cars[idx - 1];
					cars[--idx] = null;
					return;
					*/
				}
			}
			System.out.println("대상 차량이 존재하지 않습니다.");
}
	
	
	public void printAllCars() {
		
		if(idx == 0 ) {
			System.out.println("등록된 차량이 없습니다.");
			return;
			}
			String AllCars = sc.next();
			System.out.println(name + " 차량 목록");
			for(int i = 0; i < idx; i++) {
				Car car = cars[i];
				System.out.println(car);
				
			}
		
	}
	
	
	public void manage() {
		
		while(true) {
			
			System.out.print("1.추가 2.삭제 3.전체 0.종료");//이렇게 운영한다 메뉴
			
			String choice = sc.next();
			
			switch(choice) {
			case "1":
				addCar(); // addCar 호출
				break;
			case "2":
				deleteCar(); //deleteCar 호출
				break;
			case "3":
				printAllCars(); //printAllCars 호출
				break;
			case "0":
				return; // manage 메소드를 종료하자는 뜻
			default:
				System.out.println("존재하지 않는 메뉴입니다.");
					
			}
		}
	}
}
