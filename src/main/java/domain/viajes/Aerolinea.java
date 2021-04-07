package domain.viajes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Aerolinea {
    private String nombre;
    private List<Avion> aviones;
    private List<Viaje> viajes;

    public Aerolinea() {
        this.aviones = new ArrayList<>();
        this.viajes  = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Avion> getAviones() {
        return aviones;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void agregarViaje(Viaje ... viajes) {
        for (Viaje viaje: viajes) {
            viaje.setAerolinea(this);
        }
        Collections.addAll(this.viajes, viajes);
    }

    public void agregarAviones(Avion ... aviones) {
        Collections.addAll(this.aviones, aviones);
    }

    private List<Viaje> viajesDelAnioMes(Integer anio, Integer mes) {
        return this.viajes
                .stream()
                .filter(v ->
                        v.getFechaSalida().getYear() == anio
                                && v.getFechaSalida().getMonthValue() == mes
                        )
                .collect(Collectors.toList());
    }

    public Integer cantPasajerosTotales(Integer mes, Integer anio) {
        return this.viajesDelAnioMes(anio, mes)
                .stream()
                .mapToInt(Viaje::cantPasajerosTotales)
                .sum();
    }
}
