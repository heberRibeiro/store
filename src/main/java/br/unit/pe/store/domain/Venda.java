package br.unit.pe.store.domain;

import java.util.Date;

/**
 * The Class Venda.
 */
public class Venda {
	
	private Integer id;
	private Date data;
	private Integer clientId;
	private Integer formaPagamentoId;
	private Double total;
	
	/**
	 * Instantiates a new venda.
	 */
	public Venda() {
		
	}

	/**
	 * Instantiates a new venda.
	 *
	 * @param data data e hora em que ocorreu a venda
	 * @param clientId id do cliente ao qual a venda está associada
	 * @param formaPagamentoId id forma pagamento da venda
	 * @param total total da venda
	 */
	public Venda(Date data, Integer clientId, Integer formaPagamentoId, Double total) {
		this.data = data;
		this.clientId = clientId;
		this.formaPagamentoId = formaPagamentoId;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getFormaPagamentoId() {
		return formaPagamentoId;
	}

	public void setFormaPagamentoId(Integer formaPagamentoId) {
		this.formaPagamentoId = formaPagamentoId;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	
	

}
