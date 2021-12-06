package stt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class Stt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("테스트 시작");
		Stt stt = new Stt();
		stt.clovaSpeechToText("c:/dev/aiData/sample.wav", "Kor");
	}
	
	public String clovaSpeechToText(String filePathName, String language) {
		// TODO Auto-generated method stub
		String clientId = "pr52lgcfk7";
		String clientSecret = "Z6RetiX4zfG7XMsXYF5hL7Z2FhXK9qx63VFKMnLk";
		String result = null;
		try {
			String imgFile = filePathName;
			File voiceFile = new File(imgFile);

//			String language = "Kor"; 
			String apiURL = "https://naveropenapi.apigw.ntruss.com/recog/v1/stt?lang=" + language;
			URL url = new URL(apiURL);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type", "application/octet-stream");
			conn.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			conn.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

			OutputStream outputStream = conn.getOutputStream();
			FileInputStream inputStream = new FileInputStream(voiceFile);
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			outputStream.flush();
			inputStream.close();
			BufferedReader br = null;
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) { 
				br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf8"));
			} else { 
				System.out.println("error!!!!!!! responseCode= " + responseCode);
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}
			String inputLine = null;

			StringBuffer response = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			br.close();
			System.out.println(response.toString());
			result = response.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		
		System.out.println(result);
		return result;
	}
}
