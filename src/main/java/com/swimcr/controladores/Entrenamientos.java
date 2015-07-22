package com.swimcr.controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swimcr.customPojo.EntrenamientoPojo;
import com.swimcr.modelos.Entrenamiento;
import com.swimcr.servicios.AdministradorEntrenamientos;

@Controller
@RequestMapping("/entrenamientos")
public class Entrenamientos {

	@Autowired
	private AdministradorEntrenamientos administradorEntrenamientos;
	
	private Entrenamiento entrenamiento;

	@RequestMapping(method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json",
            consumes = "application/json")
	public ResponseEntity<MultiValueMap<String, String>> gestionEntrenamiento(HttpServletRequest request, @RequestBody EntrenamientoPojo entrenamientoPojo) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd,HH:mm");
		Date fecha;
		try {
			fecha = formatter.parse(entrenamientoPojo.getFecha());
			entrenamiento = new Entrenamiento();
			entrenamiento.setFecha(fecha);
			entrenamiento.setId_equipo(entrenamientoPojo.getId_equipo());
			entrenamiento.setId(entrenamientoPojo.getId());
			administradorEntrenamientos.guardarEntrenamiento(entrenamiento);
			
			result.add("fecha", formatter.format(entrenamiento.getFecha()));
			result.add("id_equipo", String.valueOf(entrenamiento.getId_equipo()));
			result.add("id", String.valueOf(entrenamiento.getId()));
			return new ResponseEntity<MultiValueMap<String, String>>(result, headers, HttpStatus.OK);
		} catch (Exception entrenamientoException) {
			return new ResponseEntity<MultiValueMap<String, String>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@RequestMapping(value = "/{id_equipo}", 
			method = RequestMethod.GET, 
			produces = "application/json")
	public ResponseEntity<String> consultaEntrenamientos(
			HttpServletRequest request,
			@PathVariable("id_equipo") int id_equipo) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		ObjectMapper mapper = new ObjectMapper();
		List<Entrenamiento> resp = administradorEntrenamientos
				.obtenerEntrenamientos(id_equipo);
		String lista = "";
		try {
			lista = mapper.writeValueAsString(resp);
			return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
		} catch (IOException ex) {
			return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
