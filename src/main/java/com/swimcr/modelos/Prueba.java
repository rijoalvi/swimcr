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
    
    
    private int id;
    private int id_entrenamiento;
    private int distancia;
    private int estilo;
    private int consecutivo;
    private String tipo;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "id_entrenamiento")
    public int getId_entrenamiento() {
        return id_entrenamiento;
    }

    @Column(name = "distancia")
    public int getDistancia() {
        return distancia;
    }

    @Column(name = "estilo")
    public int getEstilo() {
        return estilo;
    }

    @Column(name = "consecutivo")
    public int getConsecutivo() {
        return consecutivo;
    }

    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_entrenamiento")
    public void setId_entrenamiento(int id_entrenamiento) {
        this.id_entrenamiento = id_entrenamiento;
    }

    @Column(name = "distancia")
    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Column(name = "estilo")
    public void setEstilo(int estilo) {
        this.estilo = estilo;
    }

    @Column(name = "consecutivo")
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }

    @Column(name = "tipo")
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
