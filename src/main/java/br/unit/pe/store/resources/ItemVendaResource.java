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

import br.unit.pe.store.domain.ItemVenda;
import br.unit.pe.store.services.ItemVendaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "ItemVenda Endpoint", description = "Acesso aos endpoint da entidade ItemVenda", tags = { "ItemVenda Enpoints" })
@RestController
@RequestMapping(value = "/item-venda")
public class ItemVendaResource {
	
	@Autowired
	private ItemVendaService service;

	@ApiOperation(value = "Busca todas os ItemVenda")
	@GetMapping
	public ResponseEntity<List<ItemVenda>> findAll() {
		List<ItemVenda> ItemVenda = service.findAll();
		return ResponseEntity.ok().body(ItemVenda);
	}

	@ApiOperation(value = "Busca uma ItemVenda pelo ID", notes = "Este endpoint faz a busca de um ItemVenda passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<ItemVenda> findById(@PathVariable Integer id) {
		ItemVenda obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere um ItemVenda enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<ItemVenda> insert(@RequestBody ItemVenda itemVenda) {
		ItemVenda obj = service.insert(itemVenda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta um ItemVenda passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza um ItemVenda")
	@PutMapping(value = "/{id}")
	public ResponseEntity<ItemVenda> update(@RequestBody ItemVenda itemVenda, @PathVariable Integer id) {
		itemVenda = service.update(itemVenda, id);
		return ResponseEntity.ok().body(itemVenda);
	}

}
