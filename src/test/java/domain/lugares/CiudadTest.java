package domain.lugares;

import domain.BaseTest;
import domain.viajes.Vuelo;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class CiudadTest extends BaseTest {

    @Test
    public void llegan4PasajerosAMadridEl20DeMayo() {
        Vuelo vueloEzeMad = new Vuelo();
        vueloEzeMad.setDuracionEstimadaEnMins(780.00);
        vueloEzeMad.setFecha(LocalDateTime.of(2021, 5, 20, 8, 35, 0));
        vueloEzeMad.setAvion(super.buscarAvionPorcantAsientos(40));
        vueloEzeMad.setOrigen(super.buscarAeropuerto("EZE"));
        vueloEzeMad.setDestino(super.buscarAeropuerto("MAD"));
        vueloEzeMad.agregarPasajeros(
                super.buscarPasajero("Angie", "Rodriguez"),
                super.buscarPasajero("Carlos", "Polanco"),
                super.buscarPasajero("Laura", "Puerto"),
                super.buscarPasajero("Jorge", "Marin")
        );
        Ciudad madrid = super.buscarCiudad("Madrid");
        Assert.assertEquals(4, madrid.cantPasajerosQueLlegaronElDia(LocalDate.of(2021,5,20)).intValue());
    }
}
