/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.controladores;

import com.swimcr.customPojo.EntrenamientoPojo;
import com.swimcr.modelos.Entrenamiento;
import com.swimcr.modelos.Equipo;
import com.swimcr.modelos.Usuario;
import com.swimcr.servicios.AdministradorEquipos;
import com.swimcr.modelos.Prueba;
import com.swimcr.servicios.AdministradorPruebas;
import com.swimcr.servicios.AdministradorUsuarios;
import com.swimcr.servicios.AdministradorEntrenamientos;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author rijoalvi
 */
@Controller
@RequestMapping("/gestion")
public class ServiciosGestionDatos {

    private final static Logger LOGGER = Logger.getLogger(ServiciosConsulta.class.getName());
    
    @Autowired
    private AdministradorUsuarios administradorUsuarios;
    
    @Autowired
    private AdministradorEquipos administradorEquipos;
    
    @Autowired
    private AdministradorPruebas administradorPruebas;
    
    @Autowired
    private AdministradorEntrenamientos administradorEntrenamientos;
    
    private Entrenamiento entrenamiento;
    
    /************************Seccion de gestion de entrenamiento*********************************/
    @RequestMapping(value = "/entrenamiento",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity gestionEntrenamiento(HttpServletRequest request, @RequestBody EntrenamientoPojo entrenamientoPojo) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd,HH:mm");
        Date fecha;
        try {
        	fecha = formatter.parse(entrenamientoPojo.getFecha());
        } catch (Exception entrenamientoException) {
        	fecha = new Date();
        }
        entrenamiento = new Entrenamiento();
        entrenamiento.setFecha(fecha);
        entrenamiento.setId_equipo(entrenamientoPojo.getId_equipo());
        entrenamiento.setId(entrenamientoPojo.getId());
        administradorEntrenamientos.guardarEntrenamiento(entrenamiento);
System.out.println("Intento de guardar prueba");
        result.add("fecha", entrenamiento.getFecha().toString());

        return new ResponseEntity(result, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "/entrenamiento",
                    method = RequestMethod.GET)
    public ModelAndView descripcionGestionEntrenamiento(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_insercion_entrenamiento");
        modelAndView.addObject("message", "Descripci&oacute;n de c&oacute;mo funciona el m&eacute;todo/entrenamiento");
        return modelAndView;
    }
    
    
    /*********************************************************************************************/
    
    /***********************Seccion de gestion una prueba del entrenamiento***********************/
    
    @RequestMapping(value = "/entrenamiento/prueba",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity gestionPrueba(HttpServletRequest request, @RequestBody Prueba prueba) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        administradorPruebas.guardarPrueba(prueba);
	System.out.println("Intento de guardar prueba");
        result.add("tipo", prueba.getTipo());
        

        return new ResponseEntity(result, headers, HttpStatus.OK);
    }
    

    @RequestMapping(value = "/entrenamiento/prueba",
                    method = RequestMethod.GET)
    public ModelAndView descripcionGestionPruebaEntrenamiento(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_insercion_prueba");
        modelAndView.addObject("message", "Descripci&oacute;n de c&oacute;mo funciona el m&eacute;todo /gestion/entrenamiento/prueba");
        return modelAndView;
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }
    /*********************************************************************************************/
    
    /************************Seccion de gestion de entrenamiento*********************************/
    @RequestMapping(value = "/equipo",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity gestionEquipo(HttpServletRequest request, @RequestBody Equipo equipo) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        administradorEquipos.guardarEquipo(equipo);
	System.out.println("Equipo Guardado!!!");
        result.add("nombre", equipo.getNombre());

        return new ResponseEntity(result, headers, HttpStatus.OK);
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }

    @RequestMapping(value = "/equipo",
                    method = RequestMethod.GET)
    public ModelAndView descripcionGestionEquipo(ModelMap model) {
        List<String> listaProps = new ArrayList<String>();
        listaProps.add("nombre");
        listaProps.add("id_usuario");
        
        List<String> listaejemplo = new ArrayList<String>();
        listaejemplo.add("{ nombre: ANAHE,");
        listaejemplo.add("  id_usuario: 233 }");
        
        String titulo = "Inserci&oacute;n de Equipos";
        String descr1 = "para insertar un Equipo, debe enviar mediante POST un objeto con los siguientes elementos:";
        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:\n";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_insercion_equipo");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("descripcion1", descr1);
        modelAndView.addObject("listaDescripcion", listaProps);
        modelAndView.addObject("descripcion2", descr2);
        modelAndView.addObject("listaEjemplos", listaejemplo);

        return modelAndView;
    }
    /*********************************************************************************************/
    
    /************************************Seccion de gestion de usuario****************************/
    
    @RequestMapping(value = "/usuario",
                    method = RequestMethod.POST,
                    headers = "Accept=application/json",
                    produces = "application/json",
                    consumes = "application/json")
    public ResponseEntity gestionUsuario(HttpServletRequest request, @RequestBody Usuario usuario) {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add("Access-Control-Allow-Origin", "*");
        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
        administradorUsuarios.guardarUsuario(usuario);
	System.out.println("Usuario Guardado!!!");
        result.add("nombre", usuario.getNombre());
        //result.add("id", Integer.toString(nadador.getId()));

        return new ResponseEntity(result, headers, HttpStatus.OK);
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }

    @RequestMapping(value = "/usuario",
                    method = RequestMethod.GET)
    public ModelAndView descripcionGestionUsuario(ModelMap model) {
        List<String> listaProps = new ArrayList<String>();
        listaProps.add("nombre_usuario");
        listaProps.add("contrasena");
        listaProps.add("nombre");
        listaProps.add("apellidos");
        listaProps.add("email");
        listaProps.add("tipo");
        listaProps.add("edad");
        listaProps.add("categoria");
        listaProps.add("especialidad");
        
        List<String> listaejemplo = new ArrayList<String>();
        listaejemplo.add("{ nombre_usuario: juancho,");
        listaejemplo.add("  contrasena: Azul1925,");
        listaejemplo.add("  nombre: Juan,");
        listaejemplo.add("  apellidos: Alvarado Villalobos,");
        listaejemplo.add("  email: rijoalvi@gmail.com,");
        listaejemplo.add("  tipo: 1,");
        listaejemplo.add("  edad: 15,");
        listaejemplo.add("  categoria: 3,");
        listaejemplo.add("  especialidad: 2 }");
        
        String titulo = "Inserci&oacute;n de usuarios";
        String descr1 = "para insertar un usuario, debe enviar mediante POST un objeto con los siguientes elementos:";
        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:\n";
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("vista_insercion_usuario");
        modelAndView.addObject("titulo", titulo);
        modelAndView.addObject("descripcion1", descr1);
        modelAndView.addObject("listaDescripcion", listaProps);
        modelAndView.addObject("descripcion2", descr2);
        modelAndView.addObject("listaEjemplos", listaejemplo);

        
        
        return modelAndView;
        // model.addAttribute("message", "Spring 3 MVC Hello World");
        //return "hello";
    }
    
    
    
    
}
