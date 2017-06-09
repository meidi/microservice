package eurekademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import eurekademo.Application;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@EnableCircuitBreaker
@RestController
public class Application {
	
	public static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Value("${api.user.idcard}")
	String api;
	
	
	@RequestMapping("/")
	public String home() {
		log.info("log-----------我是一个注册在Eureka上的服务,第三");
		return "我是一个注册在Eureka上的服务,第三方接口[9102]: "+api;
	}
	
	@RequestMapping("/idcheck")
	public String idcheck() {
		return "ID已存在[9102]";
	}
	
	@RequestMapping("/user/check")
	public String usercheck(String name) {
		return "用户"+name+"已存在[9102]";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
