/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Usuario;
import java.util.List;

/**
 *
 * @author r.alvarado
 */
public interface UsuarioDao {
    
    public void guardarUsuario(Usuario usuario);
    public List<Usuario> obtenerUsuarios();
    public Usuario obtenerUsuarioLogin(String usuario, String contrasena);
    public Usuario obtenerPorNombreUsuario(String nombreUsuario);
    
}
