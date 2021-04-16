package domain;

import domain.lugares.Aeropuerto;
import domain.lugares.Ciudad;
import domain.lugares.Continente;
import domain.lugares.Pais;
import domain.personas.Pasajero;
import domain.viajes.Avion;
import org.junit.Before;

import java.util.*;

public abstract class BaseTest {
    protected List<Pasajero> pasajeros;
    protected List<Avion> aviones;
    protected List<Ciudad> ciudades;
    protected List<Pais> paises;
    protected List<Aeropuerto> aeropuertos;

    protected BaseTest() {
        this.pasajeros      = new ArrayList<>();
        this.aviones        = new ArrayList<>();
        this.ciudades       = new ArrayList<>();
        this.paises         = new ArrayList<>();
        this.aeropuertos    = new ArrayList<>();
    }

    @Before
    public void inicializar() {
        this.inicializarPaises();
        this.inicializarCiudades();
        this.inicializarAeropuertos();
        this.inicializarAviones();
        this.inicializarPasajeros();
    }

    private void inicializarPaises() {
        Pais[] paises = {
                new Pais("Argentina", Continente.AMERICA),
                new Pais("Alemania", Continente.EUROPA),
                new Pais("Brasil", Continente.AMERICA),
                new Pais("Chile", Continente.AMERICA),
                new Pais("España", Continente.EUROPA),
                new Pais("Estados Unidos", Continente.AMERICA),
                new Pais("India", Continente.ASIA),
                new Pais("Japón", Continente.ASIA),
        };
        Collections.addAll(this.paises, paises);
    }

    private void inicializarCiudades() {
        Ciudad[] ciudades = {
                new Ciudad("Ciudad de Buenos Aires", this.buscarPais("Argentina")),
                new Ciudad("Ezeiza", this.buscarPais("Argentina")),
                new Ciudad("Berlín", this.buscarPais("Alemania")),
                new Ciudad("Brasilia", this.buscarPais("Brasil")),
                new Ciudad("Santiago de Chile", this.buscarPais("Chile")),
                new Ciudad("Madrid", this.buscarPais("España")),
                new Ciudad("Washington D. C.", this.buscarPais("Estados Unidos")),
                new Ciudad("Nueva Delhi", this.buscarPais("India")),
                new Ciudad("Tokio", this.buscarPais("Japón"))
        };
        Collections.addAll(this.ciudades, ciudades);
    }

    private void inicializarAeropuertos() {
        Aeropuerto[] aeropuertos = {
                new Aeropuerto("Aeroparque Jorge Newbery", "AEP", this.buscarCiudad("Ciudad de Buenos Aires")),
                new Aeropuerto("Aeropuerto Internacional Ministro Pistarini", "EZE", this.buscarCiudad("Ezeiza")),
                new Aeropuerto("Brandeburgo Willy Brandt", "BER", this.buscarCiudad("Berlín")),
                new Aeropuerto("Presidente Juscelino Kubitschek", "BSB", this.buscarCiudad("Brasilia")),
                new Aeropuerto("Arturo Merino Benítez", "SCL", this.buscarCiudad("Santiago de Chile")),
                new Aeropuerto("Adolfo Suárez Madrid-Barajas", "MAD", this.buscarCiudad("Madrid")),
                new Aeropuerto("Washington-Dulles", "IAD", this.buscarCiudad("Washington D. C.")),
                new Aeropuerto("Indira Gandhi", "DEL", this.buscarCiudad("Nueva Delhi")),
                new Aeropuerto("Aeropuerto Internacional de Haneda", "HND", this.buscarCiudad("Tokio")),
        };
        Collections.addAll(this.aeropuertos, aeropuertos);
    }


    private void inicializarAviones() {
        Avion[] aviones = {
                new Avion(100),
                new Avion(40),
                new Avion(80),
                new Avion(120),
        };
        Collections.addAll(this.aviones, aviones);
    }

    private void inicializarPasajeros() {
        Pasajero[] pasajeros = {
                new Pasajero("Angie", "Rodriguez"),
                new Pasajero("Carlos", "Polanco"),
                new Pasajero("Daniela", "Acero"),
                new Pasajero("Esteban", "Ortega"),
                new Pasajero("Juan sebastian", "Romero"),
                new Pasajero("Laura", "Puerto"),
                new Pasajero("Jorge", "Marin"),
        };
        Collections.addAll(this.pasajeros, pasajeros);
    }

    protected Pais buscarPais(String nombre) {
        Optional<Pais> supuestoPais = this.paises.stream().filter(p -> p.getNombre().equals(nombre)).findFirst();
        return supuestoPais.orElse(null);
    }

    protected Ciudad buscarCiudad(String nombre) {
        Optional<Ciudad> supuestaCiudad = this.ciudades
                .stream()
                .filter(c -> c.getNombre().equals(nombre))
                .findFirst();
        return supuestaCiudad.orElse(null);
    }

    protected Avion buscarAvionPorcantAsientos(Integer cantAsientos) {
        Optional<Avion> supuestoAvion = this.aviones
                .stream()
                .filter(a -> a.getCantAsientos().equals(cantAsientos))
                .findFirst();
        return supuestoAvion.orElse(null);
    }

    protected Pasajero buscarPasajero(String nombre, String apellido) {
        Optional<Pasajero> supuestoPasajero = this.pasajeros
                .stream()
                .filter(p -> p.getNombre().equals(nombre) && p.getApellido().equals(apellido))
                .findFirst();
        return supuestoPasajero.orElse(null);
    }

    protected Aeropuerto buscarAeropuerto(String codInternacional) {
        Optional<Aeropuerto> supuestoAeropuerto = this.aeropuertos
                .stream()
                .filter(a -> a.getCodigoInternacional().equals(codInternacional))
                .findFirst();
        return supuestoAeropuerto.orElse(null);
    }
}
