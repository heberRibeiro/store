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

import br.unit.pe.store.domain.Venda;
import br.unit.pe.store.services.VendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Venda Endpoint", description = "Acesso aos endpoint da entidade Venda", tags = { "Venda Enpoints" })
@RestController
@RequestMapping(value = "/venda")
public class VendaResource {

	@Autowired
	private VendaService service;

	@ApiOperation(value = "Busca todas as Vendas")
	@GetMapping
	public ResponseEntity<List<Venda>> findAll() {
		List<Venda> Venda = service.findAll();
		return ResponseEntity.ok().body(Venda);
	}

	@ApiOperation(value = "Busca uma Venda pelo ID", notes = "Este endpoint faz a busca de uma Venda passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Integer id) {
		Venda obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere uma Venda enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Venda> insert(@RequestBody Venda Venda) {
		Venda obj = service.insert(Venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta uma Venda passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza uma Venda")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Venda> update(@RequestBody Venda Venda, @PathVariable Integer id) {
		Venda = service.update(Venda, id);
		return ResponseEntity.ok().body(Venda);
	}

}
