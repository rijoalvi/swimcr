/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.dao;

import com.swimcr.modelos.Equipo;
import java.util.List;

/**
 *
 * @author Joseiby Hernandez
 */
public interface EquipoDao {
    
    public void guardarEquipo(Equipo equipo);
    public List<Equipo> obtenerEquipos();
    public List<Equipo> obtenerEquipos(String idUsuario);
}
