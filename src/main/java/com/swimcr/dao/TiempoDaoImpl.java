/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Tiempo;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joseiby Hernandez
 */
@Repository("tiempoDao")
public class TiempoDaoImpl implements TiempoDao{
    
    private final static Logger LOGGER = Logger.getLogger(TiempoDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarTiempo(Tiempo tiempo) {
    	Session s;
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            System.out.print(e);
            s = sessionfactory.openSession();
        }
        s.saveOrUpdate(tiempo);
        s.close();
    }
    
        @Override
    public List<Tiempo> obtenerTiempos() {
        @SuppressWarnings("unchecked")
        Session s;
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            System.out.print(e);
            s = sessionfactory.openSession();
        }
        List<Tiempo> lista = s.createCriteria(Tiempo.class).list();
        s.close();
        return lista;
    }

}
