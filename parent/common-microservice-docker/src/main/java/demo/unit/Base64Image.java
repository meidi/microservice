package demo.unit;

import java.io.FileOutputStream;
import java.io.OutputStream;

import org.springframework.util.Base64Utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Image {

	/**
	 * base64字符串转换成图片
	 * 
	 * @param imgStr      base64字符串
	 * @param imgFilePath 图片存放路径
	 * @return
	 *
	 * @author ZHANGJL
	 * @dateTime 2018-02-23 14:42:17
	 */
	public static boolean Base64ToImage(String imgStr, String imgFilePath) { // 对字节数组字符串进行Base64解码并生成图片

		// 图像数据为空
		if (imgStr == null) {
			return false;
		}

		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}

			OutputStream out = new FileOutputStream(imgFilePath);
			out.write(b);
			out.flush();
			out.close();

			return true;
		} catch (Exception e) {
			return false;
		}

	}
	
 

}
