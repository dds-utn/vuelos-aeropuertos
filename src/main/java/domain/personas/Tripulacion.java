package domain.personas;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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
        Collections.addAll(this.empleados, empleados);
    }

    public void agregarVuelos(Vuelo ... vuelos) {
        Collections.addAll(this.vuelos, vuelos);
    }

    private List<Vuelo> vuelosEntre(LocalDate fechaInicial, LocalDate fechaFinal) {
        return this.vuelos
                .stream()
                .filter(
                        v ->
                                (
                                        v.getFecha().toLocalDate().isAfter(fechaInicial)
                                                || v.getFecha().toLocalDate().isEqual(fechaInicial)
                                )
                                        && (
                                        v.getFecha().toLocalDate().isBefore(fechaFinal)
                                                || v.getFecha().toLocalDate().isEqual(fechaFinal)
                                )
                )
                .collect(Collectors.toList());
    }

    public Integer cantVuelosEnMesesEntre(LocalDate fechaInicial, LocalDate fechaFinal) {
        return this.vuelosEntre(fechaInicial, fechaFinal).size();
    }
}
