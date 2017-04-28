package eurekademo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
public class Application {

	@RequestMapping("/")
	public String home() {
		return "我是一个注册在Eureka上的服务";
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
