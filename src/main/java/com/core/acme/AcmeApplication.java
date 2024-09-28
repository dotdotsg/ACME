package com.core.acme;

//
//import com.core.acme.config.SwaggerConfig;
//import com.core.acme.config.WebMvcAdapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//
//@ComponentScan(basePackages = {"com.core.acme"}
//		, excludeFilters = {
//@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = {SwaggerConfig.class, WebMvcAdapter.class})})
@SpringBootApplication
public class AcmeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeApplication.class, args);
	}

}