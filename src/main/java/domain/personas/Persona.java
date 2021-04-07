package domain.personas;

public abstract class Persona {
    private String nombre;
    private String apellido;
    private Integer nroDeDocumento;
    private TipoDeDocumento tipoDeDocumento;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getNroDeDocumento() {
        return nroDeDocumento;
    }

    public void setNroDeDocumento(Integer nroDeDocumento) {
        this.nroDeDocumento = nroDeDocumento;
    }

    public TipoDeDocumento getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(TipoDeDocumento tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }
}
