package domain.lugares;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Aeropuerto {
    private String nombre;
    private String codigoInternacional;
    private Ciudad ciudad;
    private List<Vuelo> vuelos;

    public Aeropuerto(String nombre, String codigoInternacional, Ciudad ciudad) {
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.codigoInternacional = codigoInternacional;
        this.vuelos = new ArrayList<>();
        ciudad.agregarAeropuertos(this);
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoInternacional() {
        return codigoInternacional;
    }

    public void agregarVuelos(Vuelo ... vuelos) {
        Collections.addAll(this.vuelos, vuelos);
    }

    public Integer cantVuelosQuePartieronElDia(LocalDate dia) {
        return (int) this.vuelos
                .stream()
                .filter(v -> v.getFecha().isEqual(ChronoLocalDateTime.from(dia)))
                .count();
    }

    public List<Vuelo> vuelosQueLlegaronElDia(LocalDate dia) {
        return this.vuelos
                .stream()
                .filter(v -> v.fechaDeLlegadaAproximada().toLocalDate().isEqual(dia))
                .collect(Collectors.toList());
    }

    public Integer cantVuelosQueLlegaronElDia(LocalDate dia) {
        return this.vuelosQueLlegaronElDia(dia).size();
    }

    public boolean estasEn(Ciudad unaCiudad) {
        return this.ciudad.equals(unaCiudad);
    }
}
