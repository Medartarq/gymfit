/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.seguridad;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author medar
 */
public class Hash {

    private Hash() {
    }

    public static String generar(String clave) {
        return BCrypt.hashpw(clave, BCrypt.gensalt(10));
    }

    public static boolean coincide(String clave, String hashGuardado) {
        return hashGuardado != null && BCrypt.checkpw(clave, hashGuardado);
    }    
    
}
