package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Fornecedor;
import br.unit.pe.store.repositories.FornecedorRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class FornecedorService {
	
	@Autowired
	private FornecedorRepository repository;
	
	public List<Fornecedor> findAll() {
		return repository.findAll();
	}
	
	public Fornecedor findById(Integer id) {

		try {
			Fornecedor fornecedor = repository.findById(id).get();
			return fornecedor;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Fornecedor não encotrada na base de dados.");
		}
	}

	public Fornecedor insert(Fornecedor fornecedor) {
		return repository.save(fornecedor);
	}

	public Fornecedor update(Fornecedor fornecedor, Integer id) {

		try {
			Fornecedor obj = repository.getOne(id); // return a reference to the entity
			obj.setId(fornecedor.getId());
			obj.setNome(fornecedor.getNome());
			obj.setEndereco(fornecedor.getEndereco());
			obj.setTelefone(fornecedor.getTelefone());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Fornecedor não encontrada na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Fornecedor não encontrada na base de dados para deleção.");
		}
	}
}
