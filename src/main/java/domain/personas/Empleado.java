package domain.personas;

import domain.viajes.Aerolinea;

public class Empleado extends Persona {
    private Cargo cargo;
    private Aerolinea empleador;

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
}
