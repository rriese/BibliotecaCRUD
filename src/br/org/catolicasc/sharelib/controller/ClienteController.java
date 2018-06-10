package br.org.catolicasc.sharelib.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.jpa.QueryDataModel;
import br.org.catolicasc.sharelib.bean.Cliente;
import br.org.catolicasc.sharelib.dao.ClienteDao;

@ManagedBean
public class ClienteController {

	private Cliente cliente =
			new Cliente();
	private ClienteDao clienteDao = 
			new ClienteDao();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void salva() {
		clienteDao.salva(cliente);
		this.cliente = new Cliente();
	}
	
	public List<Cliente> getClientes(){
		return this.clienteDao.listaTodos();
	}
	
	public void remove(Cliente cliente) {
		this.clienteDao.remove(cliente);
	}
	
	public QueryDataModel<Cliente> getListaPaginada(){
		return this.clienteDao.listaPaginadaLazy();
	}
}
