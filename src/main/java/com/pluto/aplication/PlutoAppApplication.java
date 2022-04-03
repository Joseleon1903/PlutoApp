package com.pluto.aplication;

import com.pluto.aplication.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class, SecurityAutoConfiguration.class})
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class PlutoAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlutoAppApplication.class, args);
	}  

}
