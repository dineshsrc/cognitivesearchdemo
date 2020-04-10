package com.cts.microsoft.cognitive.search.config;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CognitiveSearchUIServer {

	protected Logger logger = Logger.getLogger(CognitiveSearchUIServer.class.getName());

	/**
	 * Run the application using Spring Boot and an embedded servlet engine.
	 * 
	 * @param args
	 *            Program arguments - ignored.
	 */
	public static void main(String[] args) {
		SpringApplication.run(CognitiveSearchUIServer.class, args);
	}
		
}
