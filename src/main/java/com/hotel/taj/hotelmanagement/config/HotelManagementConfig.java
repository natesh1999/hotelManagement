package com.hotel.taj.hotelmanagement.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;


@Configuration
public class HotelManagementConfig {

	@Bean
	public OpenAPI swaggerDocOpenApi() {
		
		Server developmentServer = new Server();
		developmentServer.setUrl("http://localhost:8080");
		developmentServer.setDescription("this is for development");
		
		Server productionserver = new Server();
		productionserver.setUrl("http://localhost:8080");
		productionserver.setDescription("this is for production");
		
		Contact contact = new Contact();
		contact.setName("hotel management");
		contact.setEmail("help.myhotel.in");
		contact.setUrl("https://mvnrepository.com/");
		
		License license = new License();
		license.setName("2 year license");
		license.setUrl("write license provider's url");
		
		Info info = new Info();
		info.title("My Hotel");
		info.version("1.0");
		info.contact(contact);
		info.description("designed for hotel management");
		info.termsOfService("pass url");
		info.license(license);
		
		OpenAPI openApi = new OpenAPI();
		openApi.info(info);
		openApi.servers(Arrays.asList(developmentServer,productionserver));
		
		return openApi;
		
		
	}

}
