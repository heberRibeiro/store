package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Cliente;
import br.unit.pe.store.repositories.ClienteRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}
	
	public Cliente findById(Integer id) {

		try {
			Cliente cliente = repository.findById(id).get();
			return cliente;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Cliente não encotrado na base de dados.");
		}
	}

	public Cliente insert(Cliente cliente) {
		return repository.save(cliente);
	}

	public Cliente update(Cliente cliente, Integer id) {

		try {
			Cliente obj = repository.getOne(id); // return a reference to the entity
			obj.setId(cliente.getId());
			obj.setNome(cliente.getNome());
			obj.setCpf(cliente.getCpf());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Cliente não encontrada na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Cliente não encontrada na base de dados para deleção.");
		}
	}
	
	

}
