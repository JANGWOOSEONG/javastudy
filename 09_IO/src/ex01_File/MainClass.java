package ex01_File;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;


public class MainClass {
	
	/*
	  File 클래스
	  1. Java.io 패키지
	  2. 파일, 디렉터리(폴더)를 관리하는 클래스이다.
	  3. 객체 생성 방법
	  	1) new file(경로, 파일)
	  	2) new file(파일)
	  4. 경로 구분 방법
	  	1) 윈도우 : 백슬래쉬로(\)
	  	2) 리눅스 : 슬래스(/)
	*/
	
	public static void ex01() {
		
		// File.separator: 플랫폼에 따라서 자동으로 경로 구분자를 사용한다.
		// 디렉터리 관련 필수 작업
		
		File dir = new File("C:" + File.separator + "storage"); // C드라이브 아래 storage 폴더를 의미한다.
		
		
		// 없으면 만들고, 있으면 지운다.
		if(dir.exists() == false) {
			dir.mkdirs();
			System.out.println("C:" + File.separator + "storage + 생성 완료");
		} else {
			dir.delete(); // 지금 바로 지운다.
		//	dir.deleteOnExit("C:\\storage  삭제 완료"); // jvm 실행이 끝나면 지운다.
		}
		
	}
	
	public static void ex02() throws IOException { // 예외 처리를 ex02 메소드를 호출한 곳으로 넘긴다.
	
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists()==false) {
			dir.mkdirs();
			
		}
		File file = new File(dir,"myfile.txt");
		if(file.exists()==false) {
			file.createNewFile(); // 반드시 예외 처리가 필요한 코드
		} else {
			file.delete(); 
		}
		}
	public static void ex03() throws IOException {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists()==false) {
			dir.mkdirs();
		}
		File file = new File(dir, "myfile.txt");
		
		if(file.exists()==false) {
			file.createNewFile();
		}
		
		//파일의 정보 확인
		System.out.println("파일명 : " + file.getName());
		System.out.println("디렉터리명 : " + file.getParent());
		System.out.println("경로명 : " + file.getPath()); // 파일명 + 디렉터리명
		
		System.out.println("디렉터리인가?" + file.isDirectory());
		System.out.println("파일인가? " + file.isFile());
		
		long lastModified = file.lastModified(); // 최종 수정일의 타임 스탬프 값
		System.out.println("최종 수정일 : " + lastModified);
		String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(lastModified);
		System.out.println("최종 수정일 : " + lastModifiedDate);
		long size = file.length(); // 파일의 크기가 바이트 단위로 저장
		long kb = (size / 1024) + (size % 1024 != 0 ? 1 : 0);
		System.out.println("파일 크기 : " + kb + "KB"); // 킬로바이트 단위 출력(1024바이트=1킬로바이트) 그냥 하면 바이트 출력
	}
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "Program Files");
		
		File[] files = dir.listFiles();
		
		for(int i = 0; i < files.length; i++) {
			if(files[i].isHidden()==false) {
			System.out.println(files[i].getName());
		}
		}
	}
	public static void ex05() {
		
		// 문제1. 현재 시간을 이용하여 디렉터리를 생성하시오.
		// 예시)
		// C:\14\31\30
		
			LocalTime now = LocalTime.now();
			
			int hour = now.getHour();
			int minute = now.getMinute();
			int second = now.getSecond();
			
			String sep = File.separator;
			File dir = new File("C:" + sep + hour + sep + minute + sep + second);
			
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			
			System.out.println(dir);
			
			
		}
	public static void ex06() {
		
			File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator + "jdk-11.0.17");
			if(dir.exists()) {
			
			File[] list = dir.listFiles();
			int fileCount = 0;
			long totalFileSize = 0;
			for(File file : list) {
			if(file.isHidden()) {
				continue;
			}
			String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd a hh:mm ").format(file.lastModified());
			String directory = file.isDirectory() ? "<DIR>" : "";
			String size = "";
			if(file.isFile()) {
				long length = file.length();
				size = new DecimalFormat("#,##0").format(file.length());
				fileCount++;
				totalFileSize += length;
			}
			String name = file.getName();
			String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
					System.out.print(result);
			}
			System.out.println(fileCount + " 개 파일" + new DecimalFormat("#,##0").format(totalFileSize)+ " 바이트");
			}
		}
		
		
		// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
		/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
		*/
		public static void ex07() {
			
			File dir= new File("C:" + File.separator + "storage", "myfile.txt");
			
			File file = new File("C:" + File.separator + "storage", "myfile.txt");
			if(file.exists()) {
				file.delete();
			}
			if(dir.exists()) {
				dir.delete();
			}
		}
		
	
	
	public static void main(String[] args) throws IOException { // main 메소드를 호출하는 곳으로 예외 처리를 넘긴다.(개발자가 try-catch 하지 않겠다.)
		ex07();
	}
}
