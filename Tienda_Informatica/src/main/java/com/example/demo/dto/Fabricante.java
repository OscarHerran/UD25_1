package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


//INICIO DEL MAPPEO CON LOS DECORADORES INDICANDO LA FUNCIÓN DE CADA ATRIBUTO
@Entity
@Table(name = "fabricantes")
public class Fabricante {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany  // ES UNA RELACION DE 1 A MUCHOS POR LO CUAL HAY QUE ASIGNAR COMO CLAVE FORÁNEA DE LA TABLA Y COMO ATRIBUTO DE LA CLASE PARA QUE PROCESE EL MAPPEO 
	@JoinColumn(name = "id_fabricante")
	private List<Articulo> articulos;
	
	//CONSTRUCTOR POR DEFECTO
	public Fabricante() {
		
	}
	//constructor con parámetros
	public Fabricante(int id, String nombre, List<Articulo> articulos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.articulos = articulos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	//ES IMPERATIVO EL DECORADOR INDICANDO AL JSON QUE LA RELACIÓN ES 1:N Y QUE DEBE DE INDICARLA CON EL "MAPPED" A LA TABLA QUE RECIBIRÁ LA CLAVE FORÁNEA
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "Articulo")
	public List<Articulo> getArticulos() {
		return articulos;
	}
	public void setArticulos(List<Articulo> articulos) {
		this.articulos = articulos;
	}
	@Override
	public String toString() {
		return "Fabricante [id=" + id + ", nombre=" + nombre + ", articulos=" + articulos + "]";
	}

	
}
