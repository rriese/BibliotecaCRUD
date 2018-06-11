package br.org.catolicasc.sharelib.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Emprestimo implements Bean{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@NotNull
	@OneToOne
	private Cliente cliente;
	@NotNull
	@OneToOne
	private Funcionario funcionario;
	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Exemplar> exemplares;
	
	public Emprestimo() {}
	
	public Emprestimo(Cliente cliente, Funcionario funcionario, Date dataPedido) {
		setCliente(cliente);
		setFuncionario(funcionario);
		setDataPedido(dataPedido);
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id; 
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
}