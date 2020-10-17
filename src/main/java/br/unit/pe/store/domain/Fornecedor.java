package br.unit.pe.store.domain;

public class Fornecedor {

	private Integer id;
	private String nome;
	private String endereco;
	private String telefone;
	private String cnpj;
	private String email;
	
	public Fornecedor() {
		
	}

	public Fornecedor(String nome, String endereco, String telefone, String cnpj, String email) {
		super();
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cnpj = cnpj;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
