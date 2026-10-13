/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.dao;

/**
 *
 * @author medar
 */
public class DatosException extends RuntimeException {

    public DatosException(String msg, Throwable causa) {
        super(msg, causa);
    }
}
