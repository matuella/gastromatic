package com.gmatuella.gastromatic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gmatuella.gastromatic.entity.Curso;

@SpringBootApplication
@EntityScan(basePackages = {
        "com.gmatuella.gastromatic.entity"
        })
@EnableJpaRepositories(basePackages = {
        "com.gmatuella.gastromatic.repository"
        }, basePackageClasses = Curso.class)
public class Main extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Main.class, args);
	}
}
