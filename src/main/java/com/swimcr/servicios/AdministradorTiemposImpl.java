/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.servicios;

import com.swimcr.dao.TiempoDao;
import com.swimcr.modelos.Tiempo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Joseiby Hernandez
 */

@Service

public class AdministradorTiemposImpl implements AdministradorTiempos{

    @Autowired
    TiempoDao tiempoDao;
    
    @Override
    public void guardarTiempo(Tiempo tiempo) {
        tiempoDao.guardarTiempo(tiempo);
    }
    
    @Override
    public List<Tiempo> obtenerTiempos() {
        return tiempoDao.obtenerTiempos();
    }
}
