package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecondApplication {

	public static void main(String[] args) { //내장된 톰켓서버를 실행하는 메인
		//설정 안하면 8080
		SpringApplication.run(SecondApplication.class, args);
	}

}
