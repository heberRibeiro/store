package br.unit.pe.store.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Produto;
import br.unit.pe.store.repositories.ProdutoRepository;
import br.unit.pe.store.services.exceptions.DatabaseException;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public List<Produto> findAll() {
		return repository.findAll();
	}

	public Produto findById(Integer id) {
		Optional<Produto> produto = repository.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException("Produto não encotrado na base de dados."));
	}

	public Produto insert(Produto produto) {
		return repository.save(produto);
	}

	public Produto update(Integer id, Produto produto) {

		try {
			Produto obj = repository.getOne(id); // return a reference to the entity
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
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Erro no banco de dados. Confira se o Produto possui relação com outras entidades.");
		}
	}
}
