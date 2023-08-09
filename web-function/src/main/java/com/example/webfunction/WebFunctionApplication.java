package com.example.webfunction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebFunctionApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebFunctionApplication.class, args);
	}

	List<TollStation> tollStation;

	public WebFunctionApplication() {
		tollStation = new ArrayList<TollStation>();
		tollStation.add(new TollStation("100A", 111.2f, 2));
		tollStation.add(new TollStation("111C", 123.34f, 3));
		tollStation.add(new TollStation("112C", 123.34f, 4));
	}

	@Bean
	public Function<String, TollStation> retriveStation() {
		return value -> {
			System.out.println("Recevievd request for the station " + value);
			return tollStation.stream().filter(toll -> value.equals(toll.getStationId())).findAny().orElse(null);
		};
	}

}
