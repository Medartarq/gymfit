/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.seguridad;

import java.util.Optional;
import pe.gymfit.dao.UsuarioDAO;
import pe.gymfit.modelo.Usuario;
/**
 *
 * @author medar
 */
public class AuthService {

    private final UsuarioDAO dao;

    public AuthService(UsuarioDAO dao) {
        this.dao = dao;
    }

    public Optional<Usuario> iniciarSesion(String username, char[] clave) {
        Optional<Usuario> usuario = dao.buscarPorUsername(username)
                .filter(u -> Hash.coincide(new String(clave), u.getPasswordHash()));
        usuario.ifPresent(Sesion::iniciar);
        return usuario;
    }    
}
