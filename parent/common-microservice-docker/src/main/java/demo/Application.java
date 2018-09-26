package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController; 

@SpringBootApplication
@RestController
@EnableEurekaClient
public class Application {

	public static final Logger log = LoggerFactory.getLogger(Application.class);
	
    @RequestMapping("/")
    public String home() {
    	log.info("--------------http://apisec.fedwallet.net-------------");
        return "http://apisec.fedwallet.net";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
