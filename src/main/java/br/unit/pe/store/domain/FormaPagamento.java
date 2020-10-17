package br.unit.pe.store.domain;

/**
 * The Class FormaPagamento.
 */
public class FormaPagamento {
	
	private Integer id;
	private String forma;
	private String descricao;
	private Integer status;
	
	/**
	 * Instantiates a new forma pagamento.
	 */
	public FormaPagamento() {
		
	}

	/**
	 * Instantiates a new forma pagamento.
	 *
	 * @param forma forma de pagamento
	 * @param descricao descricao da forma de pagamento
	 * @param status status da forma de pagamento. 1 - ativo, 0 - inativo
	 */
	public FormaPagamento(String forma, String descricao, Integer status) {
		this.forma = forma;
		this.descricao = descricao;
		this.status = status;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getForma() {
		return forma;
	}

	public void setForma(String forma) {
		this.forma = forma;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
