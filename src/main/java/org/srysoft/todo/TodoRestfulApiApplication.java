package org.srysoft.todo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class TodoRestfulApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoRestfulApiApplication.class, args);
	}

}
