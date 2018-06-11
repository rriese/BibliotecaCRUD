package br.org.catolicasc.sharelib.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.jpa.QueryDataModel;
import br.org.catolicasc.sharelib.bean.Emprestimo;
import br.org.catolicasc.sharelib.dao.EmprestimoDao;

@ManagedBean
public class EmprestimoController {

	private Emprestimo emprestimo =
			new Emprestimo();
	private EmprestimoDao emprestimoDao = 
			new EmprestimoDao();
	private List<Integer> linhas;

	public EmprestimoController() {
		this.linhas = new ArrayList<Integer>();
		this.linhas.add(1);
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
	public List<Integer> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<Integer> linhas) {
		this.linhas = linhas;
	}

	public void salva() {
		if (emprestimo.getId() == null)
			emprestimoDao.salva(emprestimo);
		else
			emprestimoDao.atualiza(emprestimo);
		
		this.emprestimo = new Emprestimo();
	}
	
	public List<Emprestimo> getEmprestimos(){
		return this.emprestimoDao.listaTodos();
	}
	
	public void remove(Emprestimo emprestimo) {
		this.emprestimoDao.remove(emprestimo);
	}
	
	public QueryDataModel<Emprestimo> getListaPaginada(){
		return this.emprestimoDao.listaPaginadaLazy();
	}

	public String edita() {
		return "cadastraEditaEmprestimo.xhtml";
	}
	
	public void adicionaLinha() {
		this.linhas.add(1);
	}
	
	public void removeLinha(int idx) {
		this.linhas.remove(idx);
	}
}
