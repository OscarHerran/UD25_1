package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Articulo;

public interface IArticuloSERVICES {

	public List<Articulo> totalArticulos();
	public Articulo guardArticulo(Articulo arti);
	public Articulo actualizaArticulo(Articulo arti);
	public Articulo ubicaPorID(int id);
	public void eliminaArticulo(int id);
}
