package br.org.catolicasc.sharelib.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.NotNull;

@Entity
public class Funcionario implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	private String nome;
	@NotNull
	private String cpf;
	@NotNull
	private String rg;
	private String numeroTelefone;
	@NotNull
	private String cargo;

	public Funcionario() {}
	
	public Funcionario(String nome, String cpf, String rg, String numeroTelefone, String cargo) {
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setNumeroTelefone(numeroTelefone);
		setCargo(cargo);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}