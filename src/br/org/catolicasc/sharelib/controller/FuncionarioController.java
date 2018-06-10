package br.org.catolicasc.sharelib.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.jpa.QueryDataModel;
import br.org.catolicasc.sharelib.bean.Cargo;
import br.org.catolicasc.sharelib.bean.Funcionario;
import br.org.catolicasc.sharelib.dao.FuncionarioDao;

@ManagedBean
public class FuncionarioController {

	private Funcionario funcionario =
			new Funcionario();
	private FuncionarioDao funcionarioDao = 
			new FuncionarioDao();

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void salva() {
		if (funcionario.getId() == null)
			funcionarioDao.salva(funcionario);
		else
			funcionarioDao.atualiza(funcionario);
		
		this.funcionario = new Funcionario();
	}
	
	public List<Funcionario> getFuncionarios(){
		return this.funcionarioDao.listaTodos();
	}
	
	public void remove(Funcionario funcionario) {
		this.funcionarioDao.remove(funcionario);
	}
	
	public QueryDataModel<Funcionario> getListaPaginada(){
		return this.funcionarioDao.listaPaginadaLazy();
	}

	public String edita() {
		return "cadastraEditaFuncionario.xhtml";
	}
	
	public Cargo[] getCargos() {
		return Cargo.values();
	}
}
