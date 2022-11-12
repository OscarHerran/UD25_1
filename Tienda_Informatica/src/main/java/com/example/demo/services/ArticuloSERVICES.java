package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IArticuloDAO;
import com.example.demo.dto.Articulo;

@Service
public class ArticuloSERVICES implements IArticuloSERVICES {
	
	@Autowired
	IArticuloDAO articuloDAO;

	@Override
	public List<Articulo> totalArticulos() {
		
		return articuloDAO.findAll();
	}

	@Override
	public Articulo guardArticulo(Articulo arti) {
		return articuloDAO.save(arti);
	}

	@Override
	public Articulo actualizaArticulo(Articulo arti) {
		return articuloDAO.save(arti);
	}

	@Override
	public Articulo ubicaPorID(int id) {
		return articuloDAO.findById(id).get();
	}

	@Override
	public void eliminaArticulo(int id) {
		articuloDAO.deleteById(id);
	}

}
