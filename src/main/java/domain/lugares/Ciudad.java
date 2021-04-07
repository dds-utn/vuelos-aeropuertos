package domain.lugares;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad {
    private String nombre;
    private Pais pais;
    private List<Aeropuerto> aeropuertos;

    public Ciudad(Pais pais) {
        this.aeropuertos = new ArrayList<>();
        this.pais = pais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    public Integer cantDeAeropuertos() {
        return this.aeropuertos.size();
    }

    public Integer cantPasajerosQueLlegaronElDia(LocalDate dia) {
        List<Vuelo> vuelosQueLlegaronEseDia = this.aeropuertos
                .stream()
                .flatMap(a -> a.vuelosQueLlegaronElDia(dia).stream())
                .collect(Collectors.toList());

        return vuelosQueLlegaronEseDia
                .stream()
                .mapToInt(v -> v.cantPasajeros())
                .sum();
    }
}
