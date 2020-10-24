package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Produto;
import br.unit.pe.store.repositories.ProdutoRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}
	
	public Produto findById(Integer id) {

		try {
			Produto produto = repository.findById(id).get();
			return produto;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Produto não encotrado na base de dados.");
		}
	}

	public Produto insert(Produto produto) {
		return repository.save(produto);
	}

	public Produto update(Produto produto, Integer id) {

		try {
			Produto obj = repository.getOne(id); // return a reference to the entity
			obj.setId(produto.getId());
			obj.setNome(produto.getNome());
			obj.setDescricao(produto.getDescricao());
			obj.setPrecoUnitario(produto.getPrecoUnitario());
			obj.setUnidade(produto.getUnidade());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Produto não encontrado na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Produto não encontrado na base de dados para deleção.");
		}
	}
}
