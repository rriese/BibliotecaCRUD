package br.org.catolicasc.sharelib.bean;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

@Entity
public class Exemplar implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull
	@ManyToOne
	private Livro livro;
	@NotNull
	@ManyToOne
	private Estante estante;
	@Enumerated(EnumType.STRING)
	private Status status;

	public Exemplar() {}

	public Exemplar(Livro livro, Estante estante) {
		setLivro(livro);
		setEstante(estante);
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}	
}