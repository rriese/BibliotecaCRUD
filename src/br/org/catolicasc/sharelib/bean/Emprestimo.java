package br.org.catolicasc.sharelib.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@ViewScoped
public class Emprestimo implements Bean{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Funcionario funcionario;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPedido = new Date(System.currentTimeMillis());;
	
	@ManyToMany(mappedBy="emprestimos")
	private List<Exemplar> exemplares;
	
	public Emprestimo() {
		if(this.exemplares == null)
			this.exemplares = new ArrayList<Exemplar>();
	}
	
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

	public List<Exemplar> getExemplares() {
		return exemplares;
	}
	
	public void setExemplares(List<Exemplar> exemplares) {
		this.exemplares = exemplares;
	}
	
	public void addExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar);
	}

}