package com.swimcr.controladores;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.swimcr.modelos.Entrenamiento;
import com.swimcr.modelos.Equipo;
import com.swimcr.servicios.AdministradorEntrenamientos;
import com.swimcr.servicios.AdministradorEquipos;
/*package com.swimcr.app;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
*/
/**
 * Handles requests for the application home page.
 */

@Controller
public class HomeController {
	/*
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	*/
	/**
	 * Simply selects the home view to render by returning its name.
	 */
/*
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
*/
	
	@Autowired
    private AdministradorEquipos administradorEquipos;
	
	@Autowired
    private AdministradorEntrenamientos administradorEntrenamientos;
	
	@RequestMapping(value = { "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;

	}

	@RequestMapping(value = {"/", "/admin**"}, method = RequestMethod.GET)
	public ModelAndView adminPage(final HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		List<Equipo> equipos;
		List<List<Entrenamiento>> entrenamientos = new ArrayList<List<Entrenamiento>>();
		Principal currentUser;
		try{
			currentUser = request.getUserPrincipal();
			if(currentUser != null) {
				equipos = administradorEquipos.obtenerEquipos(currentUser.getName());
				for (Equipo equipo: equipos) {
					List<Entrenamiento> entrenamiento = administradorEntrenamientos.obtenerEntrenamientos(equipo.getId());
					entrenamientos.add(entrenamiento);
				}
				System.out.println("SIP");
			} else {
				equipos = new ArrayList<Equipo>();
			}
			
		} catch (Error e){
			equipos = new ArrayList<Equipo>();
		}
		
		if(equipos.size() > 0) {
			model.addObject("primerEquipo", equipos.get(0));
		}
		model.addObject("equipos", equipos);
		if(entrenamientos.size() > 0) {
			model.addObject("entrenamientos", entrenamientos);
		}
		model.setViewName("admin");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	
}
