package demo;

import org.springframework.stereotype.Service;  
import demo.jsonbean.LogBean;
import demo.unit.JsonMapper;

@Service
public class LogService { 

	public LogBean getLogBean(String json) {
		return JsonMapper.jsonToObject(json, LogBean.class);
	}
	
	
}
