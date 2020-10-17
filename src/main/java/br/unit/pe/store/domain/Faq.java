package br.unit.pe.store.domain;

import java.util.Date;

/**
 * The Class Faq.
 */
public class Faq {
	
	private Integer id;
	private String texto;
	private Date dataHora;
	private Integer produtoId;
	
	/**
	 * Instantiates a new faq.
	 */
	public Faq() {
		
	}

	/**
	 * Instantiates a new faq.
	 *
	 * @param texto texto do faq
	 * @param dataHora data hora do faq
	 * @param produtoId id do Produto
	 */
	public Faq(String texto, Date dataHora, Integer produtoId) {
		this.texto = texto;
		this.dataHora = dataHora;
		this.produtoId = produtoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}	
}
