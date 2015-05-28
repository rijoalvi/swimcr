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
@Table(name = "equipo")
public class Equipo {
    
    
    private int id;
    private String nombre;
    private String id_usuario;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }
    
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "nombre")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "id_usuario")
    public String getId_usuario() {
        return id_usuario;
    }

    @Column(name = "id_usuario")
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }
    
}
