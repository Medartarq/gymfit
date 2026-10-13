/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.gymfit.dao;

import java.util.Optional;
import pe.gymfit.modelo.Usuario;

/**
 *
 * @author medar
 */
public interface UsuarioDAO {
    
Optional<Usuario> buscarPorUsername(String username);

}
