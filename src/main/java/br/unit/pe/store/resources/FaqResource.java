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

import br.unit.pe.store.domain.Faq;
import br.unit.pe.store.services.FaqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Faq Endpoint", description = "Acesso aos endpoint da entidade Faq", tags = {"Faq Enpoints"})
@RestController
@RequestMapping(value="/faq")
public class FaqResource {
	
	@Autowired
	private FaqService service;
	
	@ApiOperation(value = "Busca todas as Faqs")
	@GetMapping
	public ResponseEntity<List<Faq>> findAll() {
		List<Faq> faq = service.findAll();
		return ResponseEntity.ok().body(faq);
	}
	
	@ApiOperation(value = "Busca um Faq pelo ID", notes = "Este endpoint faz a busca de um Faq passando o Id como parâmetro da requisição.")
	@GetMapping(value = "/{id}")
	public ResponseEntity<Faq> findById(@PathVariable Integer id) {
		Faq obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "Insere um Faq enviando um json no corpo da requisição")
	@PostMapping
	public ResponseEntity<Faq> insert(@RequestBody Faq Faq) {
		Faq obj = service.insert(Faq);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@ApiOperation(value = "Deleta um Faq passando o ID como parâmetro da requisição")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Atualiza uma Faq")
	@PutMapping(value = "/{id}")
	public ResponseEntity<Faq> update(@RequestBody Faq Faq, @PathVariable Integer id) {
		Faq = service.update(Faq, id);
		return ResponseEntity.ok().body(Faq);
	}


}
