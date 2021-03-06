package br.org.catolicasc.sharelib.bean;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.validation.constraints.NotNull;

@Entity
public class Exemplar implements Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Livro livro;
	@ManyToOne
	private Estante estante;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToMany
	private List<Emprestimo> emprestimos;

	public Exemplar() {}

	public Exemplar(Livro livro, Estante estante, Status status) {
		setLivro(livro);
		setEstante(estante);
		setStatus(status);
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}