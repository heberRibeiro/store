package br.unit.pe.store.domain;

import java.io.Serializable;

/**
 * The Class ItemVenda.
 */
public class ItemVenda implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer produtoId;
	private Integer vendaId;
	private Integer quantidade;
	private Double valorUnitario;
	
	/**
	 * Instantiates a new item venda.
	 */
	public ItemVenda() {
		
	}

	/**
	 * Instantiates a new item venda.
	 *
	 * @param produtoId produto id
	 * @param vendaId venda id
	 * @param quantidade quantidade
	 * @param valorUnitario valor unitario
	 */
	public ItemVenda(Integer produtoId, Integer vendaId, Integer quantidade, Double valorUnitario) {
		this.produtoId = produtoId;
		this.vendaId = vendaId;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getVendaId() {
		return vendaId;
	}

	public void setVendaId(Integer vendaId) {
		this.vendaId = vendaId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemVenda other = (ItemVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
