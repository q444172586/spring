package cloud.simple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;


@SpringBootApplication  //相当于@Configuration、@EnableAutoConfiguration、@ComponentScan三个注解合
//@EnableEurekaClient //配置本应用将使用服务注册和服务发现，注意：注册和发现用这一个注解。
//@EnableHystrix //表示启用断路器，断路器依赖于服务注册和发现。
public class WebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebApplication.class, args);
	}

}
