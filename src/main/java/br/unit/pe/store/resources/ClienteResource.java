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

import br.unit.pe.store.domain.Cliente;
import br.unit.pe.store.services.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Cliente Endpoint", description = "Acesso aos endpoint da entidade Cliente", tags = { "Cliente Enpoints" })
@RestController
@RequestMapping(value = "/cliente")
public class ClienteResource {

	@Autowired
	private ClienteService service;

	@ApiOperation(value = "Busca todas as Clientes")
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> Cliente = service.findAll();
		return ResponseEntity.ok().body(Cliente);
	}

	@ApiOperation(value = "Busca um Cliente pelo ID", notes = "Este endpoint faz a busca de um Cliente passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Integer id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere um Cliente enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente Cliente) {
		Cliente obj = service.insert(Cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta um Cliente passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza um Cliente")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Cliente> update(@RequestBody Cliente Cliente, @PathVariable Integer id) {
		Cliente = service.update(Cliente, id);
		return ResponseEntity.ok().body(Cliente);
	}

}
