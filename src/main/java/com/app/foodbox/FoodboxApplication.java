package com.app.foodbox;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.app.foodbox.model.Product;
import com.app.foodbox.model.User;
import com.app.foodbox.service.ProductService;
import com.app.foodbox.service.UserService;



@SpringBootApplication
public class FoodboxApplication implements ApplicationRunner{
	private UserService userService;
	private ProductService productService;
	
	@Autowired
	public FoodboxApplication(UserService userService ,ProductService productService)
	{
		this.userService=userService;
		this.productService=productService;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(FoodboxApplication.class, args);
	}
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration=new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin","Access-Control-Allow-Origin","Content-Type",
				"Accept","Authorization","Origin, Accept","X-Requested-With","Access-control-Request-Method","Access-control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin","Content-Type","Accept","Authorization","Access-Control-Allow-Origin"
				,"Access-Control-Allow-Origin","Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource= new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}
	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		userService.addUser(new User((long) 1,"admin","admin@foodbox.com","admin","0000000000","foodbox HQ,abcd","admin"));
		userService.addUser(new User((long) 2,"TestUser","user@123.com","testuser","2222255555","testuser, xyz,abcd","user"));
		
		productService.addProduct(new Product((long) 1,"Tandoori Roti","Indian",200,(float) 16,"no",""));
		productService.addProduct(new Product((long) 2,"Fried Chicken Burger","Mexican",200,(float) 120,"no",""));
		productService.addProduct(new Product((long) 3,"Margherita Pizza","Italian",200,(float) 250,"no",""));
		productService.addProduct(new Product((long) 4,"schezwan chilly chicken","Chinese",200,(float) 80,"no",""));
		productService.addProduct(new Product((long) 5,"Dal Fry","Indian",200,(float) 80,"no",""));
		productService.addProduct(new Product((long) 6,"Paneer Butter Masala","Indian",200,(float) 120,"no",""));
		productService.addProduct(new Product((long) 7,"Cheeze Burst Pizza","Italian",200,(float) 180,"no",""));
		productService.addProduct(new Product((long) 8,"Masala Dosa","Indian",200,(float) 120,"no",""));
		productService.addProduct(new Product((long) 9,"Saucy Italian Pasta","Italian",200,(float) 100,"no",""));
		productService.addProduct(new Product((long) 10,"Burritos","Mexican",200,(float) 110,"no",""));
		productService.addProduct(new Product((long) 11,"Tandoori Chicken","Indian",200,(float) 150,"no",""));		
		productService.addProduct(new Product((long) 12,"Chow mein","Chinese",200,(float) 90,"no",""));
		productService.addProduct(new Product((long) 13,"Steamed Vermicelli Rolls","Chinese",120,(float) 110,"no",""));
		productService.addProduct(new Product((long) 14,"Basic Taco","Mexican",200,(float) 100,"no",""));
		productService.addProduct(new Product((long) 15,"Spring Rolls","Chinese",200,(float) 110,"no",""));
		productService.addProduct(new Product((long) 16,"Beijing Duck","Chinese",200,(float) 300,"no",""));
		productService.addProduct(new Product((long) 17,"Tomato Salsa","Mexican",200,(float) 150,"no",""));
		productService.addProduct(new Product((long) 18,"Ramen Noodles","Chinese",200,(float) 300,"no",""));
		productService.addProduct(new Product((long) 19,"Pork Stew","Mexican",200,(float) 350,"no",""));
		productService.addProduct(new Product((long) 20,"Deviled Shrimp","Mexican",200,(float) 360,"no",""));
		productService.addProduct(new Product((long) 21,"Chilly Pasta","Italian",200,(float) 80,"no",""));
	}

}
