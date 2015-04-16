package com.swimcr.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;

/**
 *
 * @author r.alvarado
 */

@Entity
@Table(name = "entrenamiento")
public class Entrenamiento {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    
    @Column(name = "id_equipo")
    private int id_equipo;
    
    @Column(name = "fecha")
    @Type(type="date")
    private Date fecha;

    public int getId() {
        return id;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}