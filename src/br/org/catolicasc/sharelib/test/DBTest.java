package br.org.catolicasc.sharelib.test;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.org.catolicasc.sharelib.bean.Cargo;
import br.org.catolicasc.sharelib.bean.Cliente;
import br.org.catolicasc.sharelib.bean.Funcionario;
import br.org.catolicasc.sharelib.jpa.JPAUtil;

public class DBTest {

	private static EntityManager em = JPAUtil.getEntityManager();
	
	@Test
	public void salvaCliente() {
		Cliente cliente = new Cliente("Rafael Riese", "096.545.544-99", "6.595.925", "98819-2856");
		Cliente cliente1 = new Cliente("Matheus de Quadros", "086.545.541-12", "4.569.511", "98819-2857");
		Cliente cliente2 = new Cliente("Johny Klein", "076.545.54-26", "6.911.236", "98819-2858");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.persist(cliente1);
		em.persist(cliente2);
		em.getTransaction().commit();
	}
	
	@Test
	public void salvaFuncionario() {
		Funcionario funcionario = new Funcionario("Joshua de Carvalho", "256.698.777-66", "2.265.698", "98495-9987", Cargo.RECEPCIONISTA);
		Funcionario funcionario2 = new Funcionario("Sônia Abraão", "257.566.987-16", "6.665.128", "99949-8987", Cargo.BIBLIOTECARIO);
		Funcionario funcionario3 = new Funcionario("Carlos Abraão", "258.516.187-11", "1.661.118", "99911-8181", Cargo.BIBLIOTECARIO);
		
		em.getTransaction().begin();
		em.persist(funcionario);
		em.persist(funcionario2);
		em.persist(funcionario3);
		em.getTransaction().commit();
	}
	
	public void run() {
		salvaCliente();
		salvaFuncionario();
	}
	
}
