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

    private int id;
    private int id_equipo;
    private Date fecha;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public int getId() {
        return id;
    }

    @Column(name = "id_equipo")
    public int getId_equipo() {
        return id_equipo;
    }

    @Column(name = "fecha")
    @Type(type="date")
    public Date getFecha() {
        return fecha;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "id_equipo")
    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    @Column(name = "fecha")
    @Type(type="date")
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}