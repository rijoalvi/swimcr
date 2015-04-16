/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.servicios;

import com.swimcr.dao.EntrenamientoDao;
import com.swimcr.modelos.Entrenamiento;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Joseiby Hernandez
 */

@Service("administradorEntrenamientos")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = false)
public class AdministradorEntrenamientosImpl implements AdministradorEntrenamientos{

    @Autowired
    EntrenamientoDao entrenamientoDao;
    
    @Override
    public void guardarEntrenamiento(Entrenamiento entrenamiento) {
        entrenamientoDao.guardarEntrenamiento(entrenamiento);
    }
    
    @Override
    public List<Entrenamiento> obtenerEntrenamientos() {
        return entrenamientoDao.obtenerEntrenamientos();
    }
    
    @Override
    public List<Entrenamiento> obtenerEntrenamientos(int idEquipo) {
        return entrenamientoDao.obtenerEntrenamientos(idEquipo);
    }
}