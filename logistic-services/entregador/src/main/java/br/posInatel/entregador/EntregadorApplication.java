package br.posInatel.entregador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(excludeFilters = {
		@ComponentScan.Filter(type = FilterType.REGEX,pattern = "br.posInatel.client.*")
})
public class EntregadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntregadorApplication.class, args);
	}

}
