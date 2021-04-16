package domain.viajes;

public class Avion {
    private Integer cantAsientos;

    public Avion(Integer cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    public void setCantAsientos(Integer cantAsientos) {
        this.cantAsientos = cantAsientos;
    }

    public Integer getCantAsientos() {
        return cantAsientos;
    }
}
