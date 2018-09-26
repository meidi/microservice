package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.service.IDCardService;

@RestController
public class IDCardController {

	@Autowired
	private IDCardService iDCardService;
	
	@PostMapping(value = "/api/idcard")
	public String log(String imageBase64,String idCardSide) {
		System.out.println("------/api/idcard-------"+idCardSide);
		return iDCardService.baiduai(imageBase64, idCardSide);
	}
	
	
	
}
