package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Fabricante;

public interface IFabricanteSERVICES {
	
	public List<Fabricante> totalFabricante();
	public Fabricante guardaFabricantes(Fabricante fab);
	public Fabricante actualizaFabricantes(Fabricante fab);
	public Fabricante ubicaPorID(int id);
	public void eliminaFabricante(int id);
}
