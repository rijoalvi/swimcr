/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.modelos;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author rijoalvi
 */

@Entity
@Table(name = "rol", catalog="asistente_natacion_cr", uniqueConstraints = @UniqueConstraint(columnNames = { "rol", "nombre_usuario" }))
public class Rol {
    
	public Rol() {
	}

	public Rol(Usuario usuario, String rol) {
		this.usuario = usuario;
		this.rol = rol;
	}

	
	private Integer idRolUsuario;
	private Usuario usuario;
	private String rol;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_rol_usuario", unique = true, nullable = false)
	public Integer getIdRolUsuario() {
		return idRolUsuario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nombre_usuario", nullable = false)
	public Usuario getUsuario() {
		return usuario;
	}
	
	@Column(name = "rol", nullable = false, length = 45)
	public String getRol() {
		return rol;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_rol_usuario", unique = true, nullable = false)
	public void setIdRolUsuario(Integer idRolUsuario) {
		this.idRolUsuario = idRolUsuario;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nombre_usuario", nullable = false)
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "rol", nullable = false, length = 45)
	public void setRol(String rol) {
		this.rol = rol;
	}
}
