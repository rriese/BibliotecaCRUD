package br.org.catolicasc.sharelib.test;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import br.org.catolicasc.sharelib.bean.Cliente;
import br.org.catolicasc.sharelib.jpa.JPAUtil;

public class DBTest {

	private static EntityManager em = JPAUtil.getEntityManager();
	
	@Test
	public void salvaCliente() {
		Cliente cliente = new Cliente("Rafael", "09654554", "98819-2856", );
		Cliente cliente1 = new Cliente("Matheus", "08654554", "98819-2857");
		Cliente cliente2 = new Cliente("Johny", "07654554", "98819-2858");
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.persist(cliente1);
		em.persist(cliente2);
		em.getTransaction().commit();
	}
	
}
