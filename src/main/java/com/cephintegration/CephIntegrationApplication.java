package com.cephintegration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan
// http://localhost:8080/swagger-ui/index.html
public class CephIntegrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CephIntegrationApplication.class, args);
	}

}
