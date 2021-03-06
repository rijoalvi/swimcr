/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swimcr.dao;

import com.swimcr.modelos.Usuario;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author r.alvarado
 */
@Repository("usuarioDao")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class UsuarioDaoImpl implements UsuarioDao {
    
    private final static Logger LOGGER = Logger.getLogger(UsuarioDaoImpl.class.getName());
    
    @Autowired
    private SessionFactory sessionfactory;

    
    @SuppressWarnings("unchecked")
	public Usuario obtenerPorNombreUsuario(String nombreUsuario) { 
		Session s;
		s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error obtener por usuario "+e);
            //s = sessionfactory.openSession();
        }*/
        Criteria c = s.createCriteria(Usuario.class);
		c.add(Restrictions.eq("nombre_usuario", nombreUsuario));
		
		List<Usuario> listaUsuarios = c.list();
 
		if (listaUsuarios.size() > 0) {
			return listaUsuarios.get(0);
		} else {
			return null;
		}
 
	}
    
    @Override
    public void guardarUsuario(Usuario usuario) {
    	Session s;
    	s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error guardar usuario "+e);
            //s = sessionfactory.openSession();
        }*/
        s.saveOrUpdate(usuario);
        //s.close();
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        @SuppressWarnings("unchecked")
        Session s;
        s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error obtener usuarios "+e);
            //s = sessionfactory.openSession();
        }*/
        List<Usuario> listaUsuarios = s.createCriteria(Usuario.class).list();
        //s.close();
        return listaUsuarios;
    }
    
    @Override
    public Usuario obtenerUsuarioLogin(String usuario, String contrasena) {
    	Session s;
    	s = sessionfactory.getCurrentSession();
    	/*
        try {
            s = sessionfactory.getCurrentSession();
        }
        catch(Exception e) {
        	System.out.print("Error obtener usuario login "+e);
            //s = sessionfactory.openSession();
        }*/
        Criteria c = s.createCriteria(Usuario.class);
        if(usuario!=null){
		c.add(Restrictions.eq("nombre_usuario",usuario));
	}
	if(contrasena!=null){
		c.add(Restrictions.eq("contrasena",contrasena));
	}
        Usuario usuarioResp = (Usuario) c.uniqueResult();
        //s.close();
        return usuarioResp;
    }
}
