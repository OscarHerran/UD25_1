package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Fabricante;

public interface IFabricanteDAO extends JpaRepository <Fabricante, Integer>{ // CON LA EXTENSIÓN DE JPA Y EL PARÁMETRO DE LA CLASE, OBTENEMOS EL MAPPEO MEDIANTE LA INTERFAZ Y SE PUEDE INVOCAR 

}
