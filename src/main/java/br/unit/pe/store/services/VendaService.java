package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.Venda;
import br.unit.pe.store.repositories.VendaRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository repository;
	
	public List<Venda> findAll() {
		return repository.findAll();
	}
	
	public Venda findById(Integer id) {

		try {
			Venda venda = repository.findById(id).get();
			return venda;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Venda não encotrada na base de dados.");
		}
	}

	public Venda insert(Venda venda) {
		return repository.save(venda);
	}

	public Venda update(Venda venda, Integer id) {

		try {
			Venda obj = repository.getOne(id); // return a reference to the entity
			obj.setId(venda.getId());
			obj.setData(venda.getData());
			obj.setTotal(venda.getTotal());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Venda não encontrada na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Venda não encontrada na base de dados para deleção.");
		}
	}
}
