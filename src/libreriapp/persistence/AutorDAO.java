package libreriapp.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import libreriapp.entity.Autor;

/**
 * 
 * @author Felipe Herrera
 *
 */
public class AutorDAO {

	// instancia de la Interfaz EntityManagerFactory
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaAppUP");
	private final EntityManager em = emf.createEntityManager();

	public void guardarAutor(Autor autor) throws Exception {
		em.getTransaction().begin();
		em.persist(autor); // Guarda el autor en la BD
		em.getTransaction().commit();
	}

	public void modificarAutor(Autor autor) throws Exception {
		em.getTransaction().begin();
		em.merge(autor); // Sobreescribe los atributos
		em.getTransaction().commit();
	}

	public void eliminarAutor(String id) throws Exception {
		Autor autor = buscarAutorPorId(id); // Buscamos el objeto
		em.getTransaction().begin();
		em.remove(autor); // Eliminamos de la BD
		em.getTransaction().commit();
	}

	public Autor buscarAutorPorId(String id) throws Exception {
		Autor autor = em.find(Autor.class, id); // Traemos el objeto por medio de la PK (Primary Key)
		return autor;
	}
	
	public List<Autor> listarAutores() throws Exception {
		return null;
	}
}
