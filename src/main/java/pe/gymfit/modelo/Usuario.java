/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.modelo;

import pe.gymfit.seguridad.Rol;

/**
 *
 * @author medar
 */
public class Usuario {

    private final int idUsuario;
    private final String username;
    private final String passwordHash;
    private final String nombre;
    private final Rol rol;

    public Usuario(int idUsuario, String username, String passwordHash, String nombre, Rol rol) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.passwordHash = passwordHash;
        this.nombre = nombre;
        this.rol = rol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public String getNombre() {
        return nombre;
    }

    public Rol getRol() {
        return rol;
    }    
}
