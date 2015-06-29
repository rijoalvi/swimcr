/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.servicios;

import com.swimcr.dao.UsuarioDao;
import com.swimcr.modelos.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author rijoalvi
 */

@Service("administradorUsuarios")

public class AdministradorUsuariosImpl implements AdministradorUsuarios{

    @Autowired
    UsuarioDao usuarioDao;
    
    @Override
//    @Transactional(readOnly = true)
    public void guardarUsuario(Usuario usuario) {
        usuarioDao.guardarUsuario(usuario);
    }

    @Override
//    @Transactional(readOnly = false)
    public List<Usuario> obtenerUsuarios() {
        return usuarioDao.obtenerUsuarios();
    }
    
    @Override
//    @Transactional(readOnly = false)
    public Usuario obtenerUsuario(String usuario, String contrasena) {
        Usuario resp = null;
        resp =  usuarioDao.obtenerUsuarioLogin(usuario, contrasena);
        return resp;
    }
    
}
