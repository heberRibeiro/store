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

import br.unit.pe.store.domain.Marca;
import br.unit.pe.store.services.MarcaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Marca Endpoint", description = "Acesso aos endpoint da entidade Marca", tags = { "Marca Enpoints" })
@RestController
@RequestMapping(value = "/marca")
public class MarcaResource {

	@Autowired
	private MarcaService service;

	@ApiOperation(value = "Busca todas as Marcaes")
	@GetMapping
	public ResponseEntity<List<Marca>> findAll() {
		List<Marca> Marca = service.findAll();
		return ResponseEntity.ok().body(Marca);
	}

	@ApiOperation(value = "Busca uma Marca pelo ID", notes = "Este endpoint faz a busca de uma Marca passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Marca> findById(@PathVariable Integer id) {
		Marca obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere uma Marca enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Marca> insert(@RequestBody Marca Marca) {
		Marca obj = service.insert(Marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta uma Marca passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza uma Marca")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Marca> update(@RequestBody Marca Marca, @PathVariable Integer id) {
		Marca = service.update(Marca, id);
		return ResponseEntity.ok().body(Marca);
	}

}
