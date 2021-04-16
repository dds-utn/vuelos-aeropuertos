package domain.lugares;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ciudad {
    private String nombre;
    private Pais pais;
    private List<Aeropuerto> aeropuertos;

    public Ciudad(String nombre, Pais pais) {
        this.aeropuertos = new ArrayList<>();
        this.pais = pais;
        this.nombre = nombre;
        pais.agregarCiudades(this);
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

    public void agregarAeropuertos(Aeropuerto ... aeropuertos) {
        Collections.addAll(this.aeropuertos, aeropuertos);
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
