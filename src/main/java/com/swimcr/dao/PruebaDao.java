/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Prueba;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface PruebaDao {
    
    public void guardarPrueba(Prueba prueba);
    public List<Prueba> obtenerPruebas();
    public List<Prueba> obtenerPruebas(int idEntrenamiento);
}
