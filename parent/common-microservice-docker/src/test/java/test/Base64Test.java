package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.ocr.AipOcr;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Test {

	// 设置APPID/AK/SK
	public static final String APP_ID = "10719266";
	public static final String API_KEY = "301ripGjeWdAmI1hX7GpIohp";
	public static final String SECRET_KEY = "RwFZZ4LlEQDRXlo8gRRwdl3eVZjjTXnW";

	// 参数为本地图片路径
	static String image = "D:\\360Downloads\\2112682676.jpg";

	public static void main(String[] args) {
/*
		 
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		 
		HashMap<String, String> options = new HashMap<String, String>();
		options.put("detect_direction", "true");
		options.put("detect_risk", "true");

		String idCardSide = "front";*/

		String strImg = getImageStr(image);
		System.out.println(strImg);

	/*	byte[] decoded = Base64.getDecoder().decode(strImg);

		JSONObject res = client.idcard(decoded, idCardSide, options);
		System.out.println(res.toString(2));*/

	}

	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author:
	 * @CreateTime:
	 * @return
	 */
	public static String getImageStr(String imgFile) {
		InputStream inputStream = null;
		byte[] data = null;
		try {
			inputStream = new FileInputStream(imgFile);
			data = new byte[inputStream.available()];
			inputStream.read(data);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 加密
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(data);
	}

}
