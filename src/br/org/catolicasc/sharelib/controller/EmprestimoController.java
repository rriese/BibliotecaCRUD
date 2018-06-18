package br.org.catolicasc.sharelib.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.org.catolicasc.sharelib.jpa.QueryDataModel;
import br.org.catolicasc.sharelib.bean.Emprestimo;
import br.org.catolicasc.sharelib.bean.Exemplar;
import br.org.catolicasc.sharelib.dao.EmprestimoDao;

@ManagedBean
@ViewScoped
public class EmprestimoController {

	private Emprestimo emprestimo = new Emprestimo();
	private EmprestimoDao emprestimoDao = new EmprestimoDao();

	public EmprestimoController() {
	}

	public Emprestimo getEmprestimo() {
		return emprestimo;
	}

	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	public void salva() {
		if (emprestimo.getId() == null)
			emprestimoDao.salva(emprestimo);
		else
			emprestimoDao.atualiza(emprestimo);

		this.emprestimo = new Emprestimo();
	}

	public List<Emprestimo> getEmprestimos() {
		return this.emprestimoDao.listaTodos();
	}

	public void remove(Emprestimo emprestimo) {
		this.emprestimoDao.remove(emprestimo);
	}

	public QueryDataModel<Emprestimo> getListaPaginada() {
		return this.emprestimoDao.listaPaginadaLazy();
	}

	public String edita() {
		return "cadastraEditaEmprestimo.xhtml";
	}
	
	public void adicionaCarrinho(Exemplar exemplar) {
		emprestimo.addExemplar(exemplar);
	}

}
