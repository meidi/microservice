package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.stream.FileImageInputStream;

import org.json.JSONObject;
import org.springframework.util.Base64Utils;

import com.baidu.aip.ocr.AipOcr;

public class Sample {
	// 设置APPID/AK/SK
	public static final String APP_ID = "10719266";
	public static final String API_KEY = "301ripGjeWdAmI1hX7GpIohp";
	public static final String SECRET_KEY = "RwFZZ4LlEQDRXlo8gRRwdl3eVZjjTXnW";

	 // 参数为本地图片路径
    static String image = "D:\\360Downloads\\2112682676.jpg";
    
	public static void main(String[] args) {
		// 初始化一个AipOcr
		AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

		 // 传入可选参数调用接口
	    HashMap<String, String> options = new HashMap<String, String>();
	    options.put("detect_direction", "true");
	    options.put("detect_risk", "true");
	    
	    String idCardSide = "back";
	    
	   
	    JSONObject res = client.idcard(image, idCardSide, options);
	    System.out.println(res.toString(2));

	    // 参数为本地图片二进制数组
	  
		byte[] str = Base64Utils.decodeFromString(image);
		JSONObject res2 = client.idcard(str, idCardSide, options);
	    System.out.println(res2.toString(2));

	}

	// 图片到byte数组
	public static byte[] readImageFile(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}

}