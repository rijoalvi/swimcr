package com.swimcr.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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
import com.swimcr.modelos.Prueba;
import com.swimcr.servicios.AdministradorPruebas;

@Controller
@RequestMapping("/pruebas")
public class Pruebas {
	@Autowired
	private AdministradorPruebas administradorPruebas;

	
	@RequestMapping(method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json",
            consumes = "application/json")
	public ResponseEntity<MultiValueMap<String, String>> gestionPrueba(HttpServletRequest request, @RequestBody Prueba prueba) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
		administradorPruebas.guardarPrueba(prueba);
		result.add("tipo", prueba.getTipo());
		return new ResponseEntity<MultiValueMap<String, String>>(result, headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id_equipo}/{fecha_entrenamiento}", 
			method = RequestMethod.GET, 
			produces = "application/json")
	public ResponseEntity<String> consultaEntrenamientoFecha(
			HttpServletRequest request,
			@PathVariable("id_equipo") int id_equipo,
			@PathVariable("fecha_entrenamiento") String fecha_entrenamiento) {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		ObjectMapper mapper = new ObjectMapper();
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy_hh-mm",
				Locale.ENGLISH);
		Date fecha = null;
		try {
			fecha = format.parse(fecha_entrenamiento);
			List<Prueba> resp = administradorPruebas.obtenerPruebas(id_equipo,
					fecha);
			String lista = "";
			lista = mapper.writeValueAsString(resp);
			return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
