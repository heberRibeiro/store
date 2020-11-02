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

import br.unit.pe.store.domain.Categoria;
import br.unit.pe.store.services.CategoriaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Categoria Endpoint", description = "Acesso aos endpoint da entidade Categoria", tags = {"Categoria Enpoints"})
@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@ApiOperation(value = "Busca todas as Categorias")
	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categoria = service.findAll();
		return ResponseEntity.ok().body(categoria);
	}
	
	@ApiOperation(value = "Busca um Categoria pelo ID", notes = "Este endpoint faz a busca de uma Categoria passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere uma Categoria enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Categoria> insert(@RequestBody Categoria categoria) {
		Categoria obj = service.insert(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta uma Categoria passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza uma Categoria")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Categoria> update(@RequestBody Categoria categoria, @PathVariable Integer id) {
		categoria = service.update(categoria, id);
		return ResponseEntity.ok().body(categoria);
	}

}
