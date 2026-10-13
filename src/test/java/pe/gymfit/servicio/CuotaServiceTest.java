/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.servicio;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import pe.gymfit.dao.CuotaDAOMemoria;
import pe.gymfit.modelo.Cuota;
import pe.gymfit.modelo.EstadoCuota;
import pe.gymfit.modelo.MedioPago;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author medar
 */
public class CuotaServiceTest {
    
    @Test
    void registraPagoDeCuotaPendiente() {

        // Preparar una cuota pendiente.
        CuotaDAOMemoria dao = new CuotaDAOMemoria();

        dao.agregar(new Cuota(
                1,
                10,
                new BigDecimal("129.00"),
                LocalDate.of(2026, 10, 21)
        ));

        CuotaService servicio = new CuotaService(dao);

        // Intentar pagarla.
        servicio.registrarPago(
                1,
                new BigDecimal("129.00"),
                MedioPago.TARJETA
        );

        // Comprobar el resultado guardado.
        Cuota cuotaGuardada = dao.buscarPorId(1).orElseThrow();

        assertEquals(
                EstadoCuota.PAGADA,
                cuotaGuardada.getEstado()
        );
    }
}
