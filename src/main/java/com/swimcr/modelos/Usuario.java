/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rijoalvi
 */

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre_usuario")
    private String nombre_usuario;
    
    @Column(name = "contrasena")
    private String contrasena;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "tipo")
    private int tipo;
    
    @Column(name = "edad")
    private int edad;
    
    @Column(name = "categoria")
    private int categoria;
    
    @Column(name = "especialidad")
    private int especialidad;

    public int getId() {
        return id;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }

    public int getTipo() {
        return tipo;
    }

    public int getEdad() {
        return edad;
    }

    public int getCategoria() {
        return categoria;
    }

    public int getEspecialidad() {
        return especialidad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEspecialidad(int especialidad) {
        this.especialidad = especialidad;
    }
    
}
