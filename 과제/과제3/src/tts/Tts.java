package tts;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Date;

import stt.Stt;


public class Tts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tts tts = new Tts();
		String result =  tts.clovaTextToSpeech();
		System.out.println(result);
	}
	
	public String clovaTextToSpeech() {
		// TODO Auto-generated method stub
		Stt stt = new Stt();
		String result = null;
		String clientId = "pr52lgcfk7";
		String clientSecret = "Z6RetiX4zfG7XMsXYF5hL7Z2FhXK9qx63VFKMnLk";
		
		String language = "nara_call";
		String sttResult = stt.clovaSpeechToText("c:/dev/aiData/sample.wav", "Kor");
		try {
			System.out.println(sttResult);
			String text = URLEncoder.encode(sttResult, "UTF-8");
			String apiURL = "https://naveropenapi.apigw.ntruss.com/tts-premium/v1/tts";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
			con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);
			// post request
			String postParams = "speaker=" + language + "&volume=0&speed=0&pitch=0&format=mp3&text=" + text;
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();
			int responseCode = con.getResponseCode();
			BufferedReader br = null;
			if (responseCode == 200) {
				InputStream is = con.getInputStream();
				int read = 0;
				byte[] bytes = new byte[1024];

				String tempname = Long.valueOf(new Date().getTime()).toString();
				result = "sample2.mp3";
				File f = new File("c:/dev/ai/" + result);
				f.createNewFile();
				OutputStream outputStream = new FileOutputStream(f);
				while ((read = is.read(bytes)) != -1) {
					outputStream.write(bytes, 0, read);
				}
				outputStream.flush();
				outputStream.close();
				is.close();
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = br.readLine()) != null) {
					response.append(inputLine);
				}
				br.close();
				System.out.println(response.toString());
				result = response.toString();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return result;
	}
}
