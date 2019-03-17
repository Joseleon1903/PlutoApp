package com.pluto.aplication;

import com.pluto.aplication.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
})
public class PlutoAppApplication {
	public static void main(String[] args) {
		SpringApplication.run(PlutoAppApplication.class, args);
	}  

}
