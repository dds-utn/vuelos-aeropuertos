package domain.viajes;

import domain.lugares.Aeropuerto;
import domain.lugares.Ciudad;
import domain.personas.Pasajero;
import domain.personas.Tripulacion;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vuelo {
    private Aeropuerto origen;
    private Aeropuerto destino;
    private LocalDateTime fecha;
    private Double duracionEstimadaEnMins;
    private Integer cantAsientosOfrecidos;
    private Avion avion;
    private List<Pasajero> pasajeros;
    private Tripulacion tripulacion;

    public Vuelo() {
        this.pasajeros = new ArrayList<>();
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getDestino() {
        return destino;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Double getDuracionEstimadaEnMins() {
        return duracionEstimadaEnMins;
    }

    public void setDuracionEstimadaEnMins(Double duracionEstimadaEnMins) {
        this.duracionEstimadaEnMins = duracionEstimadaEnMins;
    }

    public Integer getCantAsientosOfrecidos() {
        return cantAsientosOfrecidos;
    }

    public void setCantAsientosOfrecidos(Integer cantAsientosOfrecidos) {
        this.cantAsientosOfrecidos = cantAsientosOfrecidos;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    public List<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public Tripulacion getTripulacion() {
        return tripulacion;
    }

    public void setTripulacion(Tripulacion tripulacion) {
        tripulacion.agregarVuelos(this);
        this.tripulacion = tripulacion;
    }

    public void agregarPasajeros(Pasajero ... pasajeros) {
        Collections.addAll(this.pasajeros, pasajeros);
    }

    public LocalDateTime fechaDeLlegadaAproximada() {
        return this.fecha.plusHours(this.duracionEstimadaEnMins.longValue());
    }

    public Double capacidadOcupadaPorPasajeros() {
        return (this.cantPasajeros() * 100.00) / this.avion.getCantAsientos();
    }

    public Integer cantPasajeros() {
        return this.pasajeros.size();
    }

    public boolean tuDestinoEs(Ciudad unaCiudad) {
        return this.destino.estasEn(unaCiudad);
    }
}
