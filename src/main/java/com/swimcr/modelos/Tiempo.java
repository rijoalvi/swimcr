/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.modelos;

import java.util.Date;
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
@Table(name = "tiempo")
public class Tiempo {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_prueba")
    private int id_prueba;
    
    @Column(name = "id_usuario")
    private int id_usuario;
    
    @Column(name = "tiempo")
    private Date tiempo;
    
    @Column(name = "distancia_prueba")
    private int distancia_prueba;
    
    @Column(name = "estilo_prueba")
    private int estilo_prueba;

    public int getId() {
        return id;
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public Date getTiempo() {
        return tiempo;
    }
    public int getDistancia_prueba() {
        return distancia_prueba;
    }

    public int getEstilo_prueba() {
        return estilo_prueba;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setTiempo(Date tiempo) {
        this.tiempo = tiempo;
    }

    public void setDistancia_prueba(int distancia_prueba) {
        this.distancia_prueba = distancia_prueba;
    }

    public void setEstilo_prueba(int estilo_prueba) {
        this.estilo_prueba = estilo_prueba;
    }


    
}
