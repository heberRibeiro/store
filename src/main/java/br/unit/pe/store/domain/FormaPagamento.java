package br.unit.pe.store.domain;

import java.io.Serializable;

/**
 * The Class FormaPagamento.
 */
public class FormaPagamento implements Serializable {
	private static final long serialVersionUID = 1L;
	
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
		FormaPagamento other = (FormaPagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
