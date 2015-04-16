/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.servicios;

import com.swimcr.modelos.Entrenamiento;
import java.util.List;
/**
 *
 * @author Joseiby Hernandez
 */
public interface AdministradorEntrenamientos{
    public void guardarEntrenamiento(Entrenamiento entrenamiento);
    public List<Entrenamiento> obtenerEntrenamientos();
    public List<Entrenamiento> obtenerEntrenamientos(int idEquipo);

}
