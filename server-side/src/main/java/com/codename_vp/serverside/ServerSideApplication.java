package com.codename_vp.serverside;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.codename_vp.serverside")
public class ServerSideApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerSideApplication.class, args);
		System.out.println("Welcome to Game Collector");
	}

}
