package br.unit.pe.store.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.unit.pe.store.repositories.MarcaRepository;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private MarcaRepository marcaRepository;

	@Override
	public void run(String... args) throws Exception {
		
	//	Marca marcaA = new Marca(null, "Marca A", "descrição A");
	//	Marca marcaB = new Marca(null, "Marca B", "descrição B");
		
	//	marcaRepository.saveAll(Arrays.asList(marcaA, marcaB));
	}
}
