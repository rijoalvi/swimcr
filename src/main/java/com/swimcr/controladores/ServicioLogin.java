///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.swimcr.controladores;
//
//import com.swimcr.modelos.Usuario;
//import com.swimcr.modelosTransaccionales.DatosLogin;
//import com.swimcr.servicios.AdministradorUsuarios;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//import javax.servlet.http.HttpServletRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
///**
// *
// * @author r.alvarado
// */
//@Controller
//@RequestMapping("/loginsss")
//public class ServicioLogin {
//    
//    @Autowired
//    private AdministradorUsuarios administradorUsuarios;
//
//    private final static Logger LOGGER = Logger.getLogger(ServiciosConsulta.class.getName());
//
//    
//    /************************Seccion de consulta de entrenamiento*********************************/
////    @RequestMapping(method = RequestMethod.POST,
////                    headers = "Accept=application/json",
////                    produces = "application/json",
////                    consumes = "application/json")
////    public ResponseEntity login(HttpServletRequest request, @RequestBody DatosLogin datos) {
////        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
////        headers.add("Access-Control-Allow-Origin", "*");
////        MultiValueMap<String, String> result = new LinkedMultiValueMap<String, String>();
////        Usuario respuesta = administradorUsuarios.obtenerUsuario(datos.getUsuario(), datos.getContrasena());
////
////        result.add("id", Integer.toString(respuesta.getId()));
////
////        return new ResponseEntity(result, headers, HttpStatus.OK);
////        // model.addAttribute("message", "Spring 3 MVC Hello World");
////        //return "hello";
////    }
////
////    @RequestMapping(method = RequestMethod.GET)
////    public ModelAndView descripcionLogin(ModelMap model) {
////        ModelAndView modelAndView = new ModelAndView();
////        modelAndView.setViewName("vista_logueo_usuario");
////        List<String> listaProps = new ArrayList<String>();
////        listaProps.add("nombre_usuario");
////        listaProps.add("contrasena");
////        
////        List<String> listaejemplo = new ArrayList<String>();
////        listaejemplo.add("{ nombre_usuario: juan.perez,");
////        listaejemplo.add("  contrasena: conejoS8c }");
////        
////        String titulo = "Logueo de Usuario";
////        String descr1 = "Para loguearse, debe enviar mediante POST un objeto con los siguientes elementos:";
////        String descr2 = "Un ejemplo del objeto, utilizando javascript ser&iacute;a:";
////        
////        modelAndView.addObject("titulo", titulo);
////        modelAndView.addObject("descripcion1", descr1);
////        modelAndView.addObject("listaDescripcion", listaProps);
////        modelAndView.addObject("descripcion2", descr2);
////        modelAndView.addObject("listaEjemplos", listaejemplo);
////        
////        
////        return modelAndView;
////    }
//    /*********************************************************************************************/
//    
//}