/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Prueba;
import java.util.List;
import java.util.logging.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joseiby Hernandez
 */
@Repository("pruebaDao")
public class PruebaDaoImpl implements PruebaDao{
    
    private final static Logger LOGGER = Logger.getLogger(PruebaDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public void guardarPrueba(Prueba prueba) {
       
        try {
            sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            //sessionfactory.openSession();
        }
        Session s = sessionfactory.openSession();
        s.saveOrUpdate(prueba);
        s.close();
    }
    
    @Override
    public List<Prueba> obtenerPruebas() {
        @SuppressWarnings("unchecked")
        Session s = sessionfactory.openSession();
        List<Prueba> lista = s.createCriteria(Prueba.class).list();
        s.close();
        return lista;
    }
    
    @Override
    public List<Prueba> obtenerPruebas(int idEntrenamiento) {
        Session s = sessionfactory.openSession();
        Criteria c = s.createCriteria(Prueba.class);
        c.add(Restrictions.eq("id_entrenamiento", idEntrenamiento));
        List<Prueba> resp = c.list();
        s.close();
        return resp;
    }

}
