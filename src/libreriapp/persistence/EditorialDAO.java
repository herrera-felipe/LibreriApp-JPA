package libreriapp.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import libreriapp.entity.Editorial;

public class EditorialDAO {
	
	// instancia de la Interfaz EntityManagerFactory
		private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaAppUP");
		private final EntityManager em = emf.createEntityManager();
		
		public void guardarEditorial(Editorial editorial) throws Exception {
			em.getTransaction().begin();
			em.persist(editorial);
			em.getTransaction().commit();
		}

}
