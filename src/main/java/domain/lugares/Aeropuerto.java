package domain.lugares;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Aeropuerto {
    private Ciudad ciudad;
    private List<Vuelo> vuelos;

    public Aeropuerto() {
        this.vuelos = new ArrayList<>();
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Ciudad getCiudad() {
        return ciudad;
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
                .filter(v -> v.fechaDeLlegadaAproximada().isEqual(ChronoLocalDateTime.from(dia)))
                .collect(Collectors.toList());
    }

    public Integer cantVuelosQueLlegaronElDia(LocalDate dia) {
        return this.vuelosQueLlegaronElDia(dia).size();
    }

    public boolean estasEn(Ciudad unaCiudad) {
        return this.ciudad.equals(unaCiudad);
    }
}
