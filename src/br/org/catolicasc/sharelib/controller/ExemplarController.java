package br.org.catolicasc.sharelib.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.jpa.QueryDataModel;
import br.org.catolicasc.sharelib.bean.Exemplar;
import br.org.catolicasc.sharelib.bean.Livro;
import br.org.catolicasc.sharelib.bean.Status;
import br.org.catolicasc.sharelib.dao.ExemplarDao;
import br.org.catolicasc.sharelib.dao.LivroDao;

@ManagedBean
public class ExemplarController {

	private Exemplar exemplar =
			new Exemplar();
	private ExemplarDao exemplarDao = 
			new ExemplarDao();

	public Exemplar getExemplar() {
		return exemplar;
	}

	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}
			
	public void salva() {
		if (exemplar.getId() == null)
			exemplarDao.salva(exemplar);
		else
			exemplarDao.atualiza(exemplar);
		
		this.exemplar = new Exemplar();
	}
	
	public List<Exemplar> getExemplars(){
		return this.exemplarDao.listaTodos();
	}
	
	public void remove(Exemplar exemplar) {
		this.exemplarDao.remove(exemplar);
	}
	
	public QueryDataModel<Exemplar> getListaPaginada(){
		return this.exemplarDao.listaPaginadaLazy();
	}

	public String edita() {
		return "cadastraEditaExemplar.xhtml";
	}
	
	public List<Livro> getLivros() {
		return new LivroDao().listaTodos();
	}
	
	public Status[] getStatus() {
		return Status.values();
	}
}
