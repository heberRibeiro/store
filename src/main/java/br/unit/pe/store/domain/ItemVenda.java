package br.unit.pe.store.domain;

/**
 * The Class ItemVenda.
 */
public class ItemVenda {
	
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
}
