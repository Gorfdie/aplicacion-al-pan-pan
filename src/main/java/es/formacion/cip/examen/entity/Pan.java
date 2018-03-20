package es.formacion.cip.examen.entity;

import javax.persistence.*;

@Entity
@Table(name = "pan")
public class Pan {
	private Integer id;
	private Integer tamanio;
	private String denominacion;

	public Pan() {

	}

	public Pan(Integer tamanio, String denominacion) {
		this.tamanio = tamanio;
		this.denominacion = denominacion;

	}

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getTamanio() {
		return tamanio;
	}

	public void setTamanio(Integer tamanio) {
		this.tamanio = tamanio;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
}