package br.unit.pe.store.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.unit.pe.store.domain.Produto;
import br.unit.pe.store.services.ProdutoService;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> produtos = service.findAll();
		return ResponseEntity.ok().body(produtos);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto produto) {
		Produto obj = service.insert(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Produto> update(@PathVariable Integer id, @RequestBody Produto produto) {
		produto = service.update(id, produto);
		return ResponseEntity.ok().body(produto);
	}

}
