package domain.viajes;

import domain.lugares.Aeropuerto;

public class Escala {
    private Aeropuerto aeropuerto;
    private Double duracionEnMins;

    public Aeropuerto getAeropuerto() {
        return aeropuerto;
    }

    public void setAeropuerto(Aeropuerto aeropuerto) {
        this.aeropuerto = aeropuerto;
    }

    public Double getDuracionEnMins() {
        return duracionEnMins;
    }

    public void setDuracionEnMins(Double duracionEnMins) {
        this.duracionEnMins = duracionEnMins;
    }
}
