package ex03_api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {
	
	public static void ex01() {
		
		/*
		한국환경공단_에어코리아_대기오염정보 : 시도별 실시간 측정정보 조회
		1. 서비스 URL : http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty
		2. 요청 변수(Request Parameter)
			1) serviceKey : 인증키
			2) returnType : xml 또는 json
			3) sidoName : 시도 이름
	*/
		
		String serviceKey = "+f/VvIFrOCH3yNpYRLtlzkRhGrcaNqFwC9h0/SG9sN5VAODPFeTbdVv8DFfJvv3InTg5ho9Q3hcHJMgAdMOQtg==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			String sidoName = "서울";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
			
			url = new URL (sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode()==HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			System.out.println(sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject body = obj.getJSONObject("response").getJSONObject("body");
			JSONArray items = body.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				String stationName = item.getString("stationName");
				String pm10Value = item.getString("pm10Value");
				String o3Value = item.getString("o3Value");
				System.out.println(stationName + " : 미세먼지 - " + pm10Value + ", 초미세먼지 - " + o3Value);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	한국환경공단_에어코리아_대기오염정보 : 시도별 실시간 측정정보 조회
	1. 서비스 URL : http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth
	2. 요청 변수(Request Parameter)
		1) serviceKey : 인증키
		2) returnType : xml 또는 json
		3) searchDate : 통보시간 검색
    */
	
	public static void ex02() {
		
		String serviceKey = "+f/VvIFrOCH3yNpYRLtlzkRhGrcaNqFwC9h0/SG9sN5VAODPFeTbdVv8DFfJvv3InTg5ho9Q3hcHJMgAdMOQtg==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey,"UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&searchDate=2023-01-30");
		//	sbURL.append("&searchDate=2023-02-01");
			
			url = new URL (sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode()  == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			}else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			JSONArray items = new JSONObject(sb.toString())
					.getJSONObject("response")
					.getJSONObject("body")
					.getJSONArray("items");
			for(int i = 0; i < items.length(); i ++) {
				JSONObject item = items.getJSONObject(i);
				System.out.println(item.getString("frcstOneDt") + " : " + item.getString("frcstOneCn"));
				System.out.println(item.getString("frcstTwoDt") + " : " + item.getString("frcstTwoDt"));
				System.out.println(item.getString("frcstThreeDt") + " : " + item.getString("frcstThreeDt"));
				System.out.println(item.getString("frcstFourDt") + " : " + item.getString("frcstFourDt"));
			}
			
	} catch (Exception e) {
		e.printStackTrace();
	}
}
	

	public static void main(String[] args) {
		ex02();

	}

}
