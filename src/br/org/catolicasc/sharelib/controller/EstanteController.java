package br.org.catolicasc.sharelib.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.bean.Estante;
import br.org.catolicasc.sharelib.dao.EstanteDao;
import br.org.catolicasc.sharelib.jpa.QueryDataModel;

@ManagedBean
public class EstanteController {

	private Estante estante =
			new Estante();
	private EstanteDao estanteDao = 
			new EstanteDao();

	public Estante getEstante() {
		return estante;
	}

	public void setEstante(Estante estante) {
		this.estante = estante;
	}
	
	public void salva() {
		if (estante.getId() == null)
			estanteDao.salva(estante);
		else
			estanteDao.atualiza(estante);
		
		this.estante = new Estante();
	}
	
	public List<Estante> getEstantes(){
		return this.estanteDao.listaTodos();
	}
	
	public void remove(Estante estante) {
		this.estanteDao.remove(estante);
	}
	
	public QueryDataModel<Estante> getListaPaginada(){
		return this.estanteDao.listaPaginadaLazy();
	}

	public String edita() {
		return "cadastraEditaEstante.xhtml";
	}
}
