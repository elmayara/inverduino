package Repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import Modelo.planta;

public interface plantasRepository extends CrudRepository <planta, Integer> {
	
	List<planta>findById(int id);
}
