/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.gymfit.dao;

import java.util.List;
import java.util.Optional;
import pe.gymfit.modelo.Cuota;

/**
 *
 * @author medar
 */
public interface CuotaDAO {
    
    Optional<Cuota> buscarPorId(int idCuota);

    List<Cuota> listarPendientes(int idSocio);

    void actualizarPago(Cuota cuota);
}
