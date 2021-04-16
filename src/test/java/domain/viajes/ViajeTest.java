package domain.viajes;

import domain.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class ViajeTest extends BaseTest {

    @Test
    public void viajeDura270Mins() {
        Vuelo vuelo1 = new Vuelo();
        vuelo1.setDuracionEstimadaEnMins(60.00);

        Escala escala1 = new Escala();
        escala1.setDuracionEnMins(60.00);

        Vuelo vuelo2 = new Vuelo();
        vuelo2.setDuracionEstimadaEnMins(45.00);

        Escala escala2 = new Escala();
        escala2.setDuracionEnMins(30.00);

        Vuelo vuelo3 = new Vuelo();
        vuelo3.setDuracionEstimadaEnMins(75.00);

        Viaje unViaje = new Viaje();
        unViaje.agregarVuelos(vuelo1, vuelo2, vuelo3);
        unViaje.agregarEscalas(escala1, escala2);

        Assert.assertEquals(270.00, unViaje.duracionTotalEnMins(), 0.0);
    }
}
