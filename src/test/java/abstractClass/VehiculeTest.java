package abstractClass;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class VehiculeTest {

    @Test

    public void testVehicule() {

        Vehicule vehicule = new Vehicule(2);

        assertThat(vehicule.toString()).isEqualTo("Bonjour je suis un véhicule à 2 roues");
    }


}