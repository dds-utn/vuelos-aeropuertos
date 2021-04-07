package domain.personas;

import domain.viajes.Aerolinea;

import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {
    private Cargo cargo;
    private Aerolinea empleador;
    private List<Tripulacion> tripulaciones;

    public Empleado() {
        this.tripulaciones = new ArrayList<>();
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Aerolinea getEmpleador() {
        return empleador;
    }

    public void setEmpleador(Aerolinea empleador) {
        this.empleador = empleador;
    }

    public void agregarTripulacion(Tripulacion tripulacion) {
        this.tripulaciones.add(tripulacion);
    }
}
