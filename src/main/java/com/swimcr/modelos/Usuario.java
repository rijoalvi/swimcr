/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swimcr.modelos;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rijoalvi
 */

@Entity
@Table(name = "usuario", catalog="asistente_natacion_cr")
public class Usuario {
    
    
    private String nombre_usuario;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String email;
    private int tipo;
    private int edad;
    private int categoria;
    private int especialidad;
    private boolean activo;
	private Set<Rol> rol = new HashSet<Rol>(0);
	
	public Usuario() {
	}
 
	public Usuario(String nombre_usuario, String contrasena, boolean activo) {
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.activo = activo;
	}
 
	public Usuario(String nombre_usuario, String contrasena, 
		boolean activo, Set<Rol> rol) {
		this.nombre_usuario = nombre_usuario;
		this.contrasena = contrasena;
		this.activo = activo;
		this.rol = rol;
	}

	@Id
    @Column(name = "nombre_usuario", unique = true, nullable = false, length = 45)
	public String getNombre_usuario() {
		return nombre_usuario;
	}

	@Column(name = "nombre_usuario", unique = true, nullable = false, length = 45)
	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	@Column(name = "contrasena", nullable = false, length = 60)
	public String getContrasena() {
		return contrasena;
	}

	@Column(name = "contrasena", nullable = false, length = 60)
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}

	@Column(name = "nombre")
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Column(name = "apellidos")
	public String getApellidos() {
		return apellidos;
	}

	@Column(name = "apellidos")
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Column(name = "email")
	public String getEmail() {
		return email;
	}

	@Column(name = "email")
	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "tipo")
	public int getTipo() {
		return tipo;
	}

	@Column(name = "tipo")
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Column(name = "edad")
	public int getEdad() {
		return edad;
	}

	@Column(name = "edad")
	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Column(name = "categoria")
	public int getCategoria() {
		return categoria;
	}

	@Column(name = "categoria")
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	@Column(name = "especialidad")
	public int getEspecialidad() {
		return especialidad;
	}

	@Column(name = "especialidad")
	public void setEspecialidad(int especialidad) {
		this.especialidad = especialidad;
	}
	
	@Column(name = "activo", columnDefinition = "TINYINT", nullable = false)
	public boolean isActivo() {
		return activo;
	}

	@Column(name = "activo", columnDefinition = "TINYINT", nullable = false)
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public Set<Rol> getRol() {
		return rol;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	public void setRol(Set<Rol> rol) {
		this.rol = rol;
	}
}
