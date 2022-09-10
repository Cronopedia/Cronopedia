package br.com.cronopedia.paginasapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.cronopedia.paginasapi.repository.PaginaRepository;

@SpringBootApplication
public class PaginasApiApplication {

	public static void main(String[] args) {
		PaginaRepository.init();

		SpringApplication.run(PaginasApiApplication.class, args);
	}

}
