package libreriapp.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import libreriapp.entity.Autor;
import libreriapp.entity.Editorial;
import libreriapp.entity.Libro;

/**
 * 
 * @author Felipe Herrera
 *
 */
public class LibroDAO {

	// instancia de la Interfaz EntityManagerFactory
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibreriaAppUP");
	private final EntityManager em = emf.createEntityManager();

	/*
	 * Este m�todo nos deja persistir una entidad en nuestra base de datos.
	 * Persistir es la acci�n de preservar la informaci�n de un objeto de forma
	 * permanente
	 */
	public void guardarLibro(Libro libro) throws Exception {
		em.getTransaction().begin(); // Iniciamos una transacci�n
		em.persist(libro); // Preserva la info del objeto en la BD
		em.getTransaction().commit(); // Terminamos la transacci�n
	}

	/*
	 * Este m�todo funciona igual que el m�todo persist pero, sirve para actualizar
	 * una entidad en la base de datos.
	 */
	public void modificarLibro(Libro libro) throws Exception {
		em.getTransaction().begin();
		em.merge(libro); // Sobreescribe los atributos
		em.getTransaction().commit();
	}

	/*
	 * Este m�todo llama al metodo buscarLibroPorId para traer el objeto
	 * correspondiente y usar el metodo remove, para eliminar el registro de la BD.
	 */
	public void eliminarLibro(String id) throws Exception {
		Libro libro = buscarLibroPorId(id); // Buscamos el Objeto
		em.getTransaction().begin();
		em.remove(libro); // Eliminamos de la BD
		em.getTransaction().commit();
	}

	/*
	 * Este m�todo se encarga de buscar y devolver una Entidad en la base de datos,
	 * a trav�s de su clave primaria(Id).
	 */
	public Libro buscarLibroPorId(String id) throws Exception {
		Libro libro = em.find(Libro.class, id); // Traemos el objeto por ID
		return libro;
	}

	public List<Libro> listarLibros() throws Exception {
		List<Libro> listaLibros = em.createQuery("SELECT a FROM Libro a").getResultList();
		return listaLibros;
	}

	/*
	 * Listar libros por Editorial
	 */
	public List<Libro> listarLibrosPorEditorial(Editorial editorial) {
		List<Libro> librosFiltrados = em.createQuery("SELECT a FROM Libro a WHERE a.editorial = :editorial").setParameter("editorial", editorial).getResultList();
		return librosFiltrados;
	}

	/*
	 * Listar libros por Autor
	 */
	public List<Libro> listarLibrosPorAutor(Autor autor) {
		List<Libro> librosFiltrados = em.createQuery("SELECT a FROM Libro a WHERE a.autor = :autor").setParameter("autor", autor).getResultList();
		return librosFiltrados;
	}
}
