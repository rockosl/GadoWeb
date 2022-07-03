package rocko.GadoWeb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GadoTest {

	public static void main(String[] args) {

		GadoBean gado = new GadoBean("999", 200, 500, "Negão");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bois-jpa");
		EntityManager em = emf.createEntityManager();
		

		em.getTransaction().begin();
		em.persist(gado);
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}

}
