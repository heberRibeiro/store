package br.unit.pe.store.services;

import java.util.List;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.unit.pe.store.domain.ItemVenda;
import br.unit.pe.store.repositories.ItemVendaRepository;
import br.unit.pe.store.services.exceptions.ObjectNotFoundException;

@Service
public class ItemVendaService {
	
	@Autowired
	private ItemVendaRepository repository;
	
	public List<ItemVenda> findAll(Pageable pageable) {
		return repository.findAll(pageable).getContent();
	}
	
	public ItemVenda findById(Integer id) {

		try {
			ItemVenda itemVenda = repository.findById(id).get();
			return itemVenda;

		} catch (NoSuchElementException e) {
			throw new ObjectNotFoundException("Item de Venda não encotrado na base de dados.");
		}
	}

	public ItemVenda insert(ItemVenda itemVenda) {
		return repository.save(itemVenda);
	}

	public ItemVenda update(ItemVenda itemVenda, Integer id) {

		try {
			ItemVenda obj = repository.getOne(id); // return a reference to the entity
			obj.setId(itemVenda.getId());
			obj.setQuantidade(itemVenda.getQuantidade());
			obj.setValorUnitario(itemVenda.getValorUnitario());
			
			return repository.save(obj);

		} catch (EntityNotFoundException e) {
			throw new ObjectNotFoundException("Item de Venda não encontrado na base de dados para atualização.");
		}

	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ObjectNotFoundException("Item de Venda não encontrado na base de dados para deleção.");
		}
	}
}
