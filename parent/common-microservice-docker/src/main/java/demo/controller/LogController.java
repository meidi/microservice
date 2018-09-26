package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.LogService;
import demo.jsonbean.LogBean;
import demo.jsonbean.consumer.Consumer;

@RestController
public class LogController {

	@Autowired
	private Tracer tracer;
	
	@Autowired
	private LogService logService;

	@PostMapping(value = "/docker/api/log")
	public String log(@RequestBody String json) {
		tracer.addTag("log", json); 
		LogBean logBean = logService.getLogBean(json);  
		String client_ip = logBean.getClient_ip();
		tracer.addTag("client_ip", client_ip); 
		Consumer consumer = logBean.getConsumer();
		if(consumer==null) {
			tracer.addTag("consumer", "null");  
		}else {
			tracer.addTag("username", consumer.getUsername()); 
			tracer.addTag("customid", consumer.getCustom_id());  
		}
		
		
		System.out.println(json);
		return json;
	}

}
