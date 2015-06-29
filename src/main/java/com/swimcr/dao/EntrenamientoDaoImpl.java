/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Entrenamiento;
import com.swimcr.modelos.Usuario;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joseiby Hernandez
 */
@Repository("entrenamientoDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class EntrenamientoDaoImpl implements EntrenamientoDao{
    
    private final static Logger LOGGER = Logger.getLogger(EntrenamientoDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarEntrenamiento(Entrenamiento entrenamiento) {
    	Session s;
    	s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            System.out.print("Error guardar entrenamiento "+e);
            //s = sessionfactory.openSession();
        }*/
        s.saveOrUpdate(entrenamiento);
        //s.close();
    }
    
    @Override
    public List<Entrenamiento> obtenerEntrenamientos() {
        @SuppressWarnings("unchecked")
        Session s;
        s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error obtener entrenamiento "+e);
            //s = sessionfactory.openSession();
        }*/
        List<Entrenamiento> listaEntrenamientos = s.createCriteria(Entrenamiento.class).list();
        //s.close();
        return listaEntrenamientos;
    }
    
    @Override
    public List<Entrenamiento> obtenerEntrenamientos(int idEquipo) {
        List<Entrenamiento> resp;
        Session s;
        s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error obtener entrenamientos "+e);
        	//s = sessionfactory.openSession();
        }*/
        Criteria c = s.createCriteria(Entrenamiento.class);
        c.add(Restrictions.eq("id_equipo",idEquipo));
        c.addOrder(Order.desc("fecha"));
        resp = c.list();
        return resp;
    }
    
    @Override
    public Entrenamiento obtenerEntrenamientoFecha(int idEquipo, Date fecha) {
        Entrenamiento resp;
        Session s;
        s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error obtener entrenamientos fecha "+e);
        	//s = sessionfactory.openSession();
        }*/
        Criteria c = s.createCriteria(Entrenamiento.class);
        c.add(Restrictions.eq("id_equipo", idEquipo));
        c.add(Restrictions.eq("fecha", fecha));
        c.addOrder(Order.desc("fecha"));
        resp = (Entrenamiento)c.uniqueResult();
        return resp;
    }

}
