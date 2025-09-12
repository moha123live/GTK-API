/*
 * Project: GTK
 * Developer: Mohan Kumar
 * Email: moha123live@gmail.com
 */
package com.moha123live.gtk_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class GtkApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GtkApiApplication.class, args);
	}

}
