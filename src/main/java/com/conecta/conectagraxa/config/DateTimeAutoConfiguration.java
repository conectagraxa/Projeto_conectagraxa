package com.conecta.conectagraxa.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

@Configuration 
@AutoConfigureBefore({JacksonAutoConfiguration.class})
public class DateTimeAutoConfiguration {

	
	@Bean 
	  public Jackson2ObjectMapperBuilderCustomizer 
	        jacksonObjectMapperBuilderCustomizer() { 
	    return new Jackson2ObjectMapperBuilderCustomizer() { 
	    
	    	@Override
            public void customize(Jackson2ObjectMapperBuilder jacksonObjectMapperBuilder) {
                final String dateFormat = "dd/MM/yyyy";
                final String timeFormat = "hh:mm:ss a";
                final String dateTimeFormat = "dd/MM/yyyy hh:mm:ss a";
                
                ObjectMapper objectMapper = jacksonObjectMapperBuilder.build();
                objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
                
                JavaTimeModule javaTimeModule = new JavaTimeModule();
                javaTimeModule.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(dateFormat)));
                javaTimeModule.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(dateTimeFormat)));
                javaTimeModule.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(timeFormat)));
                
                objectMapper.registerModule(javaTimeModule);
                
                jacksonObjectMapperBuilder.configure(objectMapper);
            }
        };
    }
}
