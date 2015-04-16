/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.modelosTransaccionales;

/**
 *
 * @author rijoalvi
 */
public class DatosLogin {
    private String nombre_usuario;
    private String contrasena;

    public String getUsuario() {
        return nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
