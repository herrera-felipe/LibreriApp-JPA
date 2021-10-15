package libreriapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Autor {

	@Id
	@GeneratedValue
	private String id;
	
	private String nombre;
	private Boolean alta;

	public Autor() {
	}

	public Autor(String nombre, Boolean alta) {
		this.nombre = nombre;
		this.alta = alta;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Boolean getAlta() {
		return alta;
	}

	public void setAlta(Boolean alta) {
		this.alta = alta;
	}

	@Override
	public String toString() {
		return getClass().getName() + " {\n\tid: " + id + "\n\tnombre: " + nombre + "\n\talta: " + alta + "\n}";
	}

}
