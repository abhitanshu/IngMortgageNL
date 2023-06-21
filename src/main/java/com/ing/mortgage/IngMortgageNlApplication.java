/**
 * The com.ing.mortgage package contains the main application class for the ING Mortgage NL application.
 */
package com.ing.mortgage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The IngMortgageNlApplication class is the entry point for the ING Mortgage NL application.
 */
@SpringBootApplication
public class IngMortgageNlApplication {

	/**
	 * The main method that starts the application.
	 *
	 * @param args The command-line arguments.
	 */
	public static void main(String[] args) {
		SpringApplication.run(IngMortgageNlApplication.class, args);
	}

}
