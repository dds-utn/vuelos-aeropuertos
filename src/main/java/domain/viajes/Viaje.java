package domain.viajes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Viaje {
    private List<Vuelo> vuelos;
    private List<Escala> escalas;
    private LocalDateTime fechaSalida;
    private Aerolinea aerolinea;

    public Viaje() {
        this.vuelos = new ArrayList<>();
        this.escalas = new ArrayList<>();
    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Aerolinea getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(Aerolinea aerolinea) {
        this.aerolinea = aerolinea;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public List<Escala> getEscalas() {
        return escalas;
    }

    public Integer cantPasajerosTotales() {
        /*this.vuelos
                .stream()
                .flatMap(v -> v.getPasajeros().stream())
                .collect(Collectors.toSet())
                .size(); -> Forma sin contar pasajeros repetidos */
        return this.vuelos.stream().mapToInt(Vuelo::cantPasajeros).sum();
    }

    private Double duracionTotalDeVuelos() {
        return this.vuelos.stream().mapToDouble(v -> v.getDuracionEstimadaEnMins()).sum();
    }

    private Double duracionTotalDeEscalas() {
        return this.escalas.stream().mapToDouble(Escala::getDuracionEnMins).sum();
    }

    public Double duracionTotal() {
        return this.duracionTotalDeEscalas() + this.duracionTotalDeVuelos();
    }
}
