package com.swimcr.controladores;

import java.io.IOException;
import java.security.Principal;
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
import com.swimcr.modelos.Equipo;
import com.swimcr.servicios.AdministradorEquipos;

@Controller
@RequestMapping("/equipos")
public class Equipos {
	
	@Autowired
    private AdministradorEquipos administradorEquipos;
	Principal currentUser;
	
	@RequestMapping(method = RequestMethod.GET, 
			produces = "application/json")
	public ResponseEntity<String> consultaEquipos(
			HttpServletRequest request,
			@PathVariable("id_equipo") int id_equipo) {
		
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Access-Control-Allow-Origin", "*");
		ObjectMapper mapper = new ObjectMapper();
		try {
			currentUser = request.getUserPrincipal();
			List<Equipo> resp = administradorEquipos.obtenerEquipos(currentUser.getName());
			String lista = mapper.writeValueAsString(resp);
			return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
		} catch (IOException ex) {
			return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method = RequestMethod.POST,
            headers = "Accept=application/json",
            produces = "application/json",
            consumes = "application/json")
	public ResponseEntity<MultiValueMap<String, String>> gestionEquipo(HttpServletRequest request, @RequestBody Equipo equipo) {
		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        administradorEquipos.guardarEquipo(equipo);
        result.add("id", String.valueOf(equipo.getId()));
        result.add("nombre", equipo.getNombre());
        return new ResponseEntity<MultiValueMap<String, String>>(result, headers, HttpStatus.OK);
    }

}
