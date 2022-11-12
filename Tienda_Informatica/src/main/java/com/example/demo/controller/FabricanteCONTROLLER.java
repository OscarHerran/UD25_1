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

import com.example.demo.dto.Fabricante;
import com.example.demo.services.FabricanteSERVICES;


@RestController
@RequestMapping("/api")
public class FabricanteCONTROLLER {

	@Autowired
	FabricanteSERVICES fabSERVICES;
	
	@GetMapping("/fabricantes")
	public List<Fabricante> totalFabricantes(){
		return fabSERVICES.totalFabricante();
	}
	
	@GetMapping("/fabricantes/{id}")
	public Fabricante ubicaPorID(@PathVariable (name = "id") int id) {
		Fabricante fabricante = new Fabricante();
		fabricante = fabSERVICES.ubicaPorID(id);
		return fabricante;
	}
	
	@PostMapping("/fabricantes/add")  // MAPPING POST PARA ALMACENAR EL OBJETO NUEVO
	public Fabricante guardaFabricantes(@RequestBody Fabricante fabricante) {
		return fabSERVICES.guardaFabricantes(fabricante);
	}
	
	@PutMapping("/fabricante/{id}/actualiza")
	public Fabricante actualizaFabricante(@PathVariable (name = "id") int id, @RequestBody Fabricante fab) {
		Fabricante fabSEL = new Fabricante();
		Fabricante fabACTUALIZA = new Fabricante();
		
		fabSEL = fabSERVICES.ubicaPorID(id);
		fabSEL.setNombre(fab.getNombre());
		
		fabACTUALIZA = fabSEL;
		
		return fabACTUALIZA;
	}
	
	@DeleteMapping("/fabricante/{id}/elimina")
	public void eliminaFabricantes(@PathVariable (name = "id") int id) {
		fabSERVICES.eliminaFabricante(id);
	}
}
