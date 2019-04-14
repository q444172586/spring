package cloud.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 验证
 * http://127.0.0.1:8000/spring/master
 * http://127.0.0.1:8000/cloud-config-dev.yml
 *
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication {
	
	public static void main(String[] args) {
        SpringApplication.run(ConfigServerApplication.class, args);
    }
	
}