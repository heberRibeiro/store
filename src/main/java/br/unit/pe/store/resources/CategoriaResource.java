package br.unit.pe.store.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.unit.pe.store.domain.Categoria;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Categoria Endpoint", description = "Acesso aos endpoint da entidade Categoria", tags = {"Categoria Enpoints"})
@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@GetMapping
	@ApiOperation(value = "Busca todas as Categorias de produtos")
	public ResponseEntity<Categoria> findAll() {
		Categoria cat = new Categoria(1, "nome", 1);
		return ResponseEntity.ok().body(cat);
	}

}
