/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.modelosTransaccionales;

import java.util.Date;

/**
 *
 * @author rijoalvi
 */
public class DatosConsultaPruebas {
    int id_equipo;
    Date fecha;

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }
}
