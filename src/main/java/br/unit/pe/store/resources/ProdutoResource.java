package br.unit.pe.store.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unit.pe.store.domain.Produto;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@GetMapping
	public ResponseEntity<Produto> findAll() {
		Produto prod = new Produto(1, "nome", "descricao", 1.0, "unidade", 1, 1, 1);
		return ResponseEntity.ok().body(prod);
	}

}
