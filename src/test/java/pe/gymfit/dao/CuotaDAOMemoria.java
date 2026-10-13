/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.gymfit.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import pe.gymfit.modelo.Cuota;
import pe.gymfit.modelo.EstadoCuota;
/**
 *
 * @author medar
 */
public class CuotaDAOMemoria implements CuotaDAO {

    private final Map<Integer, Cuota> datos = new HashMap<>();

    // Relaciona cada membresía con su socio.
    private final Map<Integer, Integer> sociosPorMembresia =
            new HashMap<>();

    public void agregar(Cuota cuota) {
        datos.put(cuota.getIdCuota(), copiar(cuota));
    }

    public void relacionarMembresiaConSocio(
            int idMembresia, int idSocio) {

        sociosPorMembresia.put(idMembresia, idSocio);
    }

    @Override
    public Optional<Cuota> buscarPorId(int idCuota) {
        Cuota cuota = datos.get(idCuota);

        if (cuota == null) {
            return Optional.empty();
        }

        return Optional.of(copiar(cuota));
    }

    @Override
    public List<Cuota> listarPendientes(int idSocio) {
        List<Cuota> pendientes = new ArrayList<>();

        for (Cuota cuota : datos.values()) {

            Integer socio = sociosPorMembresia.get(
                    cuota.getIdMembresia());

            if (socio != null
                    && socio.intValue() == idSocio
                    && cuota.estaPendiente()) {

                pendientes.add(copiar(cuota));
            }
        }

        pendientes.sort(
                java.util.Comparator
                        .comparing(Cuota::getFechaVencimiento)
                        .thenComparingInt(Cuota::getIdCuota));

        return pendientes;
    }

    @Override
    public void actualizarPago(Cuota cuota) {
        Cuota guardada = datos.get(cuota.getIdCuota());

        if (guardada == null
                || !guardada.estaPendiente()
                || guardada.getMonto()
                        .compareTo(cuota.getMonto()) != 0) {

            throw new pe.gymfit.servicio.PagoInvalidoException(
                    "La cuota cambió o ya no está pendiente.");
        }

        if (cuota.getEstado() != EstadoCuota.PAGADA
                || cuota.getMedio() == null
                || cuota.getFechaPago() == null) {

            throw new pe.gymfit.servicio.PagoInvalidoException(
                    "Los datos del pago están incompletos.");
        }

        datos.put(cuota.getIdCuota(), copiar(cuota));
    }

    private Cuota copiar(Cuota original) {
        Cuota copia = new Cuota(
                original.getIdCuota(),
                original.getIdMembresia(),
                original.getMonto(),
                original.getFechaVencimiento()
        );

        copia.cargarPago(
                original.getEstado(),
                original.getMedio(),
                original.getFechaPago()
        );

        return copia;
    }  
}
