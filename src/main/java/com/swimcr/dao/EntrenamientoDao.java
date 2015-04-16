/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Entrenamiento;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface EntrenamientoDao {
    
    public void guardarEntrenamiento(Entrenamiento entrenamiento);
    public List<Entrenamiento> obtenerEntrenamientos();
    public List<Entrenamiento> obtenerEntrenamientos(int idEquipo);
    public Entrenamiento obtenerEntrenamientoFecha(int idEquipo, Date fecha);
}
