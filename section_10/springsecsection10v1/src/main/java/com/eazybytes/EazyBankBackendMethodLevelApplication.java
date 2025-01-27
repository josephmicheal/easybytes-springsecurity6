package com.eazybytes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true,jsr250Enabled = true)
public class EazyBankBackendMethodLevelApplication {

	public static void main(String[] args) {
		SpringApplication.run(EazyBankBackendMethodLevelApplication.class, args);
	}

}
