package com.sydoruk.fuel_history;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FuelHistoryApplication {

	public static void main(String[] args) {
		System.out.println("HV = " + org.hibernate.Version.getVersionString());
		SpringApplication.run(FuelHistoryApplication.class, args);
	}

}
