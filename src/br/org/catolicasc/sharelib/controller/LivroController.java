package br.org.catolicasc.sharelib.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.jpa.QueryDataModel;
import br.org.catolicasc.sharelib.bean.Genero;
import br.org.catolicasc.sharelib.bean.Livro;
import br.org.catolicasc.sharelib.dao.LivroDao;

@ManagedBean
public class LivroController {

	private Livro livro =
			new Livro();
	private LivroDao livroDao = 
			new LivroDao();

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void salva() {
		if (livro.getId() == null)
			livroDao.salva(livro);
		else
			livroDao.atualiza(livro);
		
		this.livro = new Livro();
	}
	
	public List<Livro> getLivros(){
		return this.livroDao.listaTodos();
	}
	
	public void remove(Livro livro) {
		this.livroDao.remove(livro);
	}
	
	public QueryDataModel<Livro> getListaPaginada(){
		return this.livroDao.listaPaginadaLazy();
	}

	public String edita() {
		return "cadastraEditaLivro.xhtml";
	}
	
	public Genero[] getGeneros() {
		return Genero.values();
	}
}
