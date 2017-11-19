package com.mo.rpi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RaspberryPiGpioApplication {

	public static void main(String[] args)
	{
		System.setProperty("pi4j.linking", "dynamic");
		SpringApplication.run(RaspberryPiGpioApplication.class, args);
	}
}
