package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Articulo;
import com.example.demo.services.ArticuloSERVICES;

@RestController
@RequestMapping("/api")
public class ArticuloCONTROLLER {

	@Autowired
	ArticuloSERVICES articuloSERVICES;
	
	@GetMapping("/articulos")
	public List<Articulo> totalArticulo(){
		return articuloSERVICES.totalArticulos();
	}
	
	@GetMapping("/articulos/{id}")
	public Articulo ubicaPorID(@PathVariable (name = "id") int id) {
		return articuloSERVICES.ubicaPorID(id);
	}
	
	@PostMapping("/articulos/add")
	public Articulo guardaArticulo(@RequestBody Articulo arti) {
		return articuloSERVICES.guardArticulo(arti);
	}
	
	@PutMapping("/articulos/{id}/actualiza")
	public Articulo actualizaArticulo(@PathVariable (name = "id") int id, @RequestBody Articulo arti) {
		Articulo artiSel = new Articulo();
		Articulo artiActualizado = new Articulo();
		
		artiSel = articuloSERVICES.ubicaPorID(id);
		artiSel.setNombre(arti.getNombre());
		artiSel.setPrecio(arti.getPrecio());
		artiSel.setFabricante(arti.getFabricante());
		
		artiActualizado = artiSel;
		
		return artiActualizado;
	}
	
	@DeleteMapping("/articulos/{id}/elimina")
	public void eliminaArticulo(@PathVariable (name = "id") int id) {
		articuloSERVICES.eliminaArticulo(id);
	}
}
