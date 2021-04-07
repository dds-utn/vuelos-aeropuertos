package domain.personas;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tripulacion {
    private String nombre;
    private List<Empleado> empleados;
    private List<Vuelo> vuelos;

    public Tripulacion() {
        this.empleados = new ArrayList<>();
        this.vuelos    = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void agregarEmpleados(Empleado ... empleados) {
        for(Empleado empleado : empleados){
            empleado.agregarTripulacion(this);
        }
        Collections.addAll(this.empleados, empleados);
    }

    public void agregarVuelos(Vuelo ... vuelos) {
        Collections.addAll(this.vuelos, vuelos);
    }

    public Integer cantVuelosEntre(LocalDate fechaInicial, LocalDate fechaFinal) {
        return (int) this.vuelos
                .stream()
                .filter(
                        v ->
                                (
                                        v.getFecha().isAfter(ChronoLocalDateTime.from(fechaInicial))
                                                || v.getFecha().isEqual(ChronoLocalDateTime.from(fechaInicial))
                                )
                                        && (
                                                v.getFecha().isBefore(ChronoLocalDateTime.from(fechaFinal))
                                                        || v.getFecha().isEqual(ChronoLocalDateTime.from(fechaFinal))
                                )
                )
                .count();
    }
}
