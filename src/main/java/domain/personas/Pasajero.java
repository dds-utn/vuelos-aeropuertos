package domain.personas;

import domain.lugares.Ciudad;
import domain.lugares.Pais;
import domain.viajes.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Persona {
    private List<Vuelo> vuelos;
    private Integer nroDePasaporte;
    private Pais nacionalidad;

    public Pasajero() {
        this.vuelos = new ArrayList<>();
    }

    public Integer getNroDePasaporte() {
        return nroDePasaporte;
    }

    public void setNroDePasaporte(Integer nroDePasaporte) {
        this.nroDePasaporte = nroDePasaporte;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public Integer cantVuelosTotales() {
        return this.vuelos.size();
    }

    public Integer cantVecesQueVisitaste(Ciudad unaCiudad) {
        return (int) this.vuelos
                .stream()
                .filter(v -> v.tuDestinoEs(unaCiudad))
                .count();
    }
}
