package br.unit.pe.store.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping
	@ApiOperation(value = "Busca todas as Categorias de produtos")
	public ResponseEntity<List<Categoria>> findAll() {
		List<Categoria> categoria = service.findAll();
		return ResponseEntity.ok().body(categoria);
	}

}
