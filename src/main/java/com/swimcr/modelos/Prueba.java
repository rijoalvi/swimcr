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
@Table(name = "prueba")
public class Prueba {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_entrenamiento")
    private int id_entrenamiento;
    
    @Column(name = "distancia")
    private int distancia;
    
    @Column(name = "estilo")
    private int estilo;
    
    @Column(name = "consecutivo")
    private int consecutivo;
    
    @Column(name = "tipo")
    private String tipo;

    public int getId() {
        return id;
    }

    public int getId_entrenamiento() {
        return id_entrenamiento;
    }

    public int getDistancia() {
        return distancia;
    }

    public int getEstilo() {
        return estilo;
    }

    public int getConsecutivo() {
        return consecutivo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_entrenamiento(int id_entrenamiento) {
        this.id_entrenamiento = id_entrenamiento;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
