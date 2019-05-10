package Controlador;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import Modelo.planta;

@Controller
@RequestMapping()
public class mainController {

	@Autowired
	private Repositorios.plantasRepository plantasRepository;
	
	@CrossOrigin
	@GetMapping(path="/Prueba")
	public @ResponseBody Status prueba(){
		return new Status(1000,"Prueba");
	}
	
	
	@CrossOrigin 
	@PostMapping(path="/addP")
	public @ResponseBody planta addP(@RequestBody planta plantas) {
		plantasRepository.save(plantas);
		return plantas;
	}
	
	@CrossOrigin
	@GetMapping(path="/allP")
	public @ResponseBody Iterable<planta>getAllPlantas(){
		return plantasRepository.findAll();
	}
	@CrossOrigin
	@PutMapping(path="/UpdP")
	public @ResponseBody Object updatePlantas(@RequestBody planta newPlanta) {
		
		if(newPlanta.getId()==null) {
			return new Status(0,"ID no definida en la request");
		}
		Optional<planta>newOpcionalPlanta=plantasRepository.findById(newPlanta.getId());
		if(!newOpcionalPlanta.isPresent()) {
			return new Status(404,"Planta no encontrada");
		}
		return plantasRepository.save(newPlanta);
	}
	
	@CrossOrigin
	@DeleteMapping(path="/DltPlanta/")
	public @ResponseBody  Object deletePlanta(@PathVariable("id") Integer id) {
		if(plantasRepository.existsById(id)) {
			plantasRepository.deleteById(id);
			return new Status(200,"ok");
		}
		return new Status(404,"No existe la planta que desea Borrar");
	}
	
}
