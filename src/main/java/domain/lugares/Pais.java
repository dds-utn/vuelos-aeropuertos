package domain.lugares;

import java.util.ArrayList;
import java.util.List;

public class Pais {
    private String nombre;
    private Continente continente;
    private List<Ciudad> ciudades;

    public Pais() {
        this.ciudades = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    public void agregarCiudad(String nombre) {
        Ciudad unaCiudad = new Ciudad(this);
        unaCiudad.setNombre(nombre);
        this.ciudades.add(unaCiudad);
    }
}
