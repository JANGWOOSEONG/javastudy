package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainClass {
	
	public static void ex01() {
		
		/*
		    한국공항공사_항공기 운항정보 : 공항 코드 정보
		    1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		    2. 요청변수(Request Parameter)
		    	1)ServiceKey : 인증키
		*/
		/*
			String encodingKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1%2BwT%2B5jqamBef%2FErC%2F5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ%3D%3D";
			String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
			apiURL += "?ServiceKey=" + encodingKey;
		*/
		
		String serviceKey = "+f/VvIFrOCH3yNpYRLtlzkRhGrcaNqFwC9h0/SG9sN5VAODPFeTbdVv8DFfJvv3InTg5ho9Q3hcHJMgAdMOQtg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) { // HttpURLConnection.HTTP_OK이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			//read(),read(char[]cbuf),readLine()
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage","공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void ex02() {
		
		/*
	    한국공항공사_항공기 운항정보 : 국제선운항스케줄
	    1. 서비스 URL : http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList
	    2. 요청변수(Request Parameter)
	    	1) ServiceKey : 인증키
	    	2) pageNo : 조회할 페이지번호
	    	3) schDate : 검색일자
	    	4) schDepiCityCode : 출발도시코드
	    	5) schArrviCityCode : 도착도시코드
	*/
		
		String serviceKey = "+f/VvIFrOCH3yNpYRLtlzkRhGrcaNqFwC9h0/SG9sN5VAODPFeTbdVv8DFfJvv3InTg5ho9Q3hcHJMgAdMOQtg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&pageNo=1";
			apiURL += "&schDate=20230201";
			apiURL += "&schDepCityCode=ICN";
			apiURL += "&schArrvCityCode=JFK";
			
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) { // HttpURLConnection.HTTP_OK이 200을 의미한다.
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			//read(),read(char[]cbuf),readLine()
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage","국제선운항스케줄.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선운항스케줄.xml이 생성되었습니다.");
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ex02();
	}
}
