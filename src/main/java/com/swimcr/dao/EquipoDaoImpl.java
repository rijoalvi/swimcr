/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;
import com.swimcr.modelos.Equipo;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Joseiby Hernandez
 */
@Repository("equipoDao")
public class EquipoDaoImpl implements EquipoDao{
    
    private final static Logger LOGGER = Logger.getLogger(EquipoDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;
    
    @Override
    public List<Equipo> obtenerEquipos() {
        @SuppressWarnings("unchecked")
        Session s;
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            System.out.print(e);
            s = sessionfactory.openSession();
        }
        List<Equipo> listaEquipos = s.createCriteria(Equipo.class).list();
        return listaEquipos;
    }

    @Override
    public void guardarEquipo(Equipo equipo) {
    	Session s;
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            System.out.print(e);
            s = sessionfactory.openSession();
        }
        s.saveOrUpdate(equipo);
        s.close();
    }
    
    @Override
    public List<Equipo> obtenerEquipos(int idUsuario) {
        List<Equipo> resp;
        Session s;
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
            System.out.print(e);
            s = sessionfactory.openSession();
        }
        Criteria c = s.createCriteria(Equipo.class);
        c.add(Restrictions.eq("id_usuario",idUsuario));
        resp = c.list();
        System.out.println(resp.toArray().length);
        s.close();
        return resp;
    }
}