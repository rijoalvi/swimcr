/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swimcr.controladores;

import com.swimcr.modelos.Entrenamiento;
import com.swimcr.modelos.Equipo;
import com.swimcr.modelos.Prueba;
import com.swimcr.modelos.Tiempo;
import com.swimcr.servicios.AdministradorEntrenamientos;
import com.swimcr.servicios.AdministradorEquipos;
import com.swimcr.servicios.AdministradorPruebas;
import com.swimcr.servicios.AdministradorTiempos;
import com.swimcr.modelosTransaccionales.DatosConsultaEntrenamiento;
import com.swimcr.modelosTransaccionales.DatosConsultaEquipo;
import com.swimcr.modelosTransaccionales.DatosConsultaPruebas;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author r.alvarado
 */
@Controller
@RequestMapping("/consulta")
public class ServiciosConsulta {

    private final static Logger LOGGER = Logger.getLogger(ServiciosConsulta.class.getName());
    
    @Autowired
    private AdministradorEquipos administradorEquipos;
    
    @Autowired
    private AdministradorEntrenamientos administradorEntrenamientos;
    
    @Autowired
    private AdministradorPruebas administradorPruebas;
    
     @Autowired
    private AdministradorTiempos administradorTiempos;

    
    /************************Seccion de consulta de entrenamiento*********************************/
    @RequestMapping(value = "/entrenamiento/fecha",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity consultaEntrenamientoFecha(HttpServletRequest request, @RequestBody DatosConsultaPruebas datos) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
        Date fecha = null;
		try {
			fecha = format.parse(datos.getFecha());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //Date fechaMasUno = new Date(datos.getFecha().getTime() +(1000 * 60 * 60 * 24));
		if(fecha != null) {
			List<Prueba> resp = administradorPruebas.obtenerPruebas(datos.getId_equipo(), fecha);
	        String lista ="";
	        try {
	            lista = mapper.writeValueAsString(resp);
	            return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
	        } catch (IOException ex) {
	        	return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		} else {
			return new ResponseEntity<String>(headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
    }

    @RequestMapping(value = "/entrenamiento/fecha",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaEntrenamientoFecha(ModelMap model) {
        List<String> listaProps = new ArrayList<String>();
        listaProps.add("id_equipo");
        listaProps.add("fecha");
        
        List<String> listaejemplo = new ArrayList<String>();
        listaejemplo.add("{ id_equipo: 23,");
        listaejemplo.add("  fecha: 2014-06-21 }");
        
        String titulo = "Consulta de Pruebas";
        String descr1 = "para consultar la lista de pruebas que tiene un entrenamiento de una fecha espec&iacute;fica, es necesario enviar mediante POST un objeto con los siguientes elementos:";
        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:\n";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_consulta_pruebas_fecha");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("descripcion1", descr1);
        modelAndView.addObject("listaDescripcion", listaProps);
        modelAndView.addObject("descripcion2", descr2);
        modelAndView.addObject("listaEjemplos", listaejemplo);
        
        return modelAndView;
    }
 
    
    
    
    /************************Seccion de consulta de equipo por idUsuario****************************/
    @RequestMapping(value = "/equipos",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity<String> consultaEquiposIdUsuario(HttpServletRequest request, @RequestBody DatosConsultaEquipo datos) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
   //     List<Equipo> resp = administradorEquipos.obtenerEquipos(datos.getId_usuario());
        String lista ="";
 //       try {
//            lista = mapper.writeValueAsString(resp);
 //       } catch (IOException ex) {
            
   //     }
        return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/equipos",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaEquiposIdUsuario(ModelMap model) {
        List<String> listaProps = new ArrayList<String>();
        listaProps.add("id_usuario");
        
        List<String> listaejemplo = new ArrayList<String>();
        listaejemplo.add("{ id_usuario: 233 }");
        
        String titulo = "Consulta de Equipos";
        String descr1 = "para consultar la lista de equipos que tiene un usuario, es necesario enviar mediante POST un objeto con los siguientes elementos:";
        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:\n";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_consulta_equipos");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("descripcion1", descr1);
        modelAndView.addObject("listaDescripcion", listaProps);
        modelAndView.addObject("descripcion2", descr2);
        modelAndView.addObject("listaEjemplos", listaejemplo);
        
        return modelAndView;
    }
    
    /************************Seccion de consulta de Entrenamientos por idEntrenamiento****************************/
    @RequestMapping(value = "/entrenamiento",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity<String> consultaEntrenamientos(HttpServletRequest request, @RequestBody DatosConsultaEntrenamiento datos) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        List<Entrenamiento> resp = administradorEntrenamientos.obtenerEntrenamientos(datos.getId_equipo());
        String lista ="";
        try {
            lista = mapper.writeValueAsString(resp);
        } catch (IOException ex) {
            
        }
        return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/entrenamiento",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaEntrenamientos(ModelMap model) {
        List<String> listaProps = new ArrayList<String>();
        listaProps.add("id_equipo");
        
        List<String> listaejemplo = new ArrayList<String>();
        listaejemplo.add("{ id_equipo: 231 }");
        
        String titulo = "Consulta de Entrenamientos";
        String descr1 = "para consultar la lista de entrenamientos que tiene un equipo, es necesario enviar mediante POST un objeto con los siguientes elementos:";
        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:\n";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_consulta_entrenamientos");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("descripcion1", descr1);
        modelAndView.addObject("listaDescripcion", listaProps);
        modelAndView.addObject("descripcion2", descr2);
        modelAndView.addObject("listaEjemplos", listaejemplo);
        
        return modelAndView;
    }
    
    @RequestMapping(value = "/tiempos",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity<String> consultaTiempos(HttpServletRequest request, @RequestBody DatosConsultaEntrenamiento datos) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        ObjectMapper mapper = new ObjectMapper();
        List<Tiempo> resp = administradorTiempos.obtenerTiempos();
        String lista ="";
        try {
            lista = mapper.writeValueAsString(resp);
        } catch (IOException ex) {
            
        }
        return new ResponseEntity<String>(lista, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/tiempos",
                    method = RequestMethod.GET)
    public ModelAndView descripcionConsultaTiempos(ModelMap model) {
        List<String> listaProps = new ArrayList<String>();
        listaProps.add("id_equipo");
        
        List<String> listaejemplo = new ArrayList<String>();
        listaejemplo.add("{ id_equipo: 231 }");
        
        String titulo = "Consulta de Tiempos";
        String descr1 = "para consultar la lista de Tiempos que tiene un equipo, es necesario enviar mediante POST un objeto con los siguientes elementos:";
        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:\n";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_consulta_entrenamientos");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("descripcion1", descr1);
        modelAndView.addObject("listaDescripcion", listaProps);
        modelAndView.addObject("descripcion2", descr2);
        modelAndView.addObject("listaEjemplos", listaejemplo);
        
        return modelAndView;
    }
}
