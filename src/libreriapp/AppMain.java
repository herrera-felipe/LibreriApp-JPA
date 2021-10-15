package libreriapp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Felipe Herrera
 *
 */
public class AppMain {
	
	public static void main(String[] args) {
		
		// Creamos las Tablas
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaAppUP");
		EntityManager em = emf.createEntityManager();
		
	}

}
