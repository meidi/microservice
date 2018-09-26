package demo.unit;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.util.Base64Utils;

import com.baidu.aip.ocr.AipOcr;

public class BaiduAI {
	
	// 设置APPID/AK/SK
	public static final String APP_ID = "10719266";
	public static final String API_KEY = "301ripGjeWdAmI1hX7GpIohp";
	public static final String SECRET_KEY = "RwFZZ4LlEQDRXlo8gRRwdl3eVZjjTXnW";
	
	public static AipOcr client  = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
	
 
	
	public static JSONObject getAIdata(String imageBase64,String idCardSide,HashMap<String,String> options) { 
		byte[] str = Base64Utils.decodeFromString(imageBase64);
		JSONObject res2 = client.idcard(str, idCardSide, options); 
		return res2; 
	}
	

}
