package domain.viajes;

import domain.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class VueloTest extends BaseTest {

    @Test
    public void vueloOcupadoAl10() {
        Vuelo vueloArgMad = new Vuelo();
        vueloArgMad.setAvion(super.buscarAvionPorcantAsientos(40));
        vueloArgMad.setOrigen(super.buscarAeropuerto("EZE"));
        vueloArgMad.setDestino(super.buscarAeropuerto("MAD"));
        vueloArgMad.agregarPasajeros(
                super.buscarPasajero("Angie", "Rodriguez"),
                super.buscarPasajero("Carlos", "Polanco"),
                super.buscarPasajero("Laura", "Puerto"),
                super.buscarPasajero("Jorge", "Marin")
                );
        Assert.assertEquals(10.00, vueloArgMad.capacidadRealOcupadaPorPasajeros(), 0.0);
    }
}
