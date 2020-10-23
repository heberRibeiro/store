package br.unit.pe.store.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unit.pe.store.domain.Categoria;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@GetMapping
	public ResponseEntity<Categoria> findAll() {
		Categoria cat = new Categoria(1, "nome", 1);
		return ResponseEntity.ok().body(cat);
	}

}
