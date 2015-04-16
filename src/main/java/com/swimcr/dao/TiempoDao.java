/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Tiempo;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface TiempoDao {
    
    public void guardarTiempo(Tiempo entrenamiento);
    public List<Tiempo> obtenerTiempos();
}