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

import br.unit.pe.store.domain.Fornecedor;
import br.unit.pe.store.services.FornecedorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Fornecedor Endpoint", description = "Acesso aos endpoint da entidade Fornecedor", tags = {
		"Fornecedor Enpoints" })
@RestController
@RequestMapping(value = "/fornecedor")
public class FornecedorResource {

	@Autowired
	private FornecedorService service;

	@ApiOperation(value = "Busca todas os Fornecedores")
	@GetMapping
	public ResponseEntity<List<Fornecedor>> findAll() {
		List<Fornecedor> fornecedor = service.findAll();
		return ResponseEntity.ok().body(fornecedor);
	}

	@ApiOperation(value = "Busca um Fornecedor pelo ID", notes = "Este endpoint faz a busca de um Fornecedor passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> findById(@PathVariable Integer id) {
		Fornecedor obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere um Fornecedor enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Fornecedor> insert(@RequestBody Fornecedor Fornecedor) {
		Fornecedor obj = service.insert(Fornecedor);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta um Fornecedor passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza uma Fornecedor")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Fornecedor> update(@RequestBody Fornecedor Fornecedor, @PathVariable Integer id) {
		Fornecedor = service.update(Fornecedor, id);
		return ResponseEntity.ok().body(Fornecedor);
	}

}
