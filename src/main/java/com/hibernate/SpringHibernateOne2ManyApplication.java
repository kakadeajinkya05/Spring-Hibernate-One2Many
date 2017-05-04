package com.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.json.Jackson2DatatypeHelper;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class SpringHibernateOne2ManyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringHibernateOne2ManyApplication.class, args);
	}
	
	@Bean
	public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
	 MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
	 ObjectMapper objectMapper = new ObjectMapper();
//	 objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//	 objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	 objectMapper.registerSubtypes(Hibernate5Module.class);
	 jsonConverter.setObjectMapper(objectMapper);
	 Jackson2DatatypeHelper.configureObjectMapper(objectMapper);
	 return jsonConverter;
	}
	
}
