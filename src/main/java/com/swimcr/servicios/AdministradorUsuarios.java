/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.servicios;

import com.swimcr.modelos.Usuario;
import java.util.List;
/**
 *
 * @author rijoalvi
 */
public interface AdministradorUsuarios {
    public void guardarUsuario(Usuario usuario);
    public List<Usuario> obtenerUsuarios();
    public Usuario obtenerUsuario(String usuario, String contrasena);
}
