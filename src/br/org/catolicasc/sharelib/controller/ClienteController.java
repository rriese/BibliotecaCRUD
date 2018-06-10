package br.org.catolicasc.sharelib.controller;

import javax.faces.bean.ManagedBean;

import br.org.catolicasc.sharelib.bean.Cliente;
import br.org.catolicasc.sharelib.dao.ClienteDao;

@ManagedBean
public class ClienteController {

	private Cliente cliente =
			new Cliente();
	private ClienteDao clienteDao = 
			new ClienteDao();
	
	public void salva() {
		clienteDao.salva(cliente);
		this.cliente = new Cliente();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
