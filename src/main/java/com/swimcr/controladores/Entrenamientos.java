package com.swimcr.controladores;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swimcr.modelos.Entrenamiento;
import com.swimcr.modelos.Prueba;
import com.swimcr.modelosTransaccionales.DatosConsultaEntrenamiento;
import com.swimcr.modelosTransaccionales.DatosConsultaPruebas;
import com.swimcr.servicios.AdministradorEntrenamientos;
import com.swimcr.servicios.AdministradorPruebas;

@Controller
@RequestMapping("/entrenamiento")
public class Entrenamientos {

	@Autowired
	private AdministradorEntrenamientos administradorEntrenamientos;

	@Autowired
	private AdministradorPruebas administradorPruebas;

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
		} catch (IOException ex) {

		}
		return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
	}

	/************************ Seccion de consulta de entrenamiento *********************************/
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
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy,hh:mm",
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
			return new ResponseEntity<String>(headers,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
