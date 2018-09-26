package demo.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;
import org.json.JSONObject;
import demo.unit.BaiduAI;

@Service
public class IDCardService {

	public String baiduai(String imageBase64, String idCardSide) {
		// 传入可选参数调用接口
		HashMap<String, String> options = new HashMap<String, String>();

		options.put("detect_direction", "true");
		options.put("detect_risk", "true");

		JSONObject res2 = BaiduAI.getAIdata(imageBase64, idCardSide, options);
		
		return res2.toString(2);

	}

}
