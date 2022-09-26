package us.charterbank.online.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AddressTest {

    @ParameterizedTest
    @CsvSource({
            "Pearlman Ave, 1094, Franklin, 02038, MA, USA, '1094 Pearlman Ave, Franklin, MA 02038, USA'",
            "Randolph St, 2949, Mattapoisett, 02739, MA, USA, '2949 Randolph St, Mattapoisett, MA 02739, USA'",
            "Rue du Faubourg Saint-Honoré, 54, Paris, 75008, IdF, FRA, '54 Rue du Faubourg Saint-Honoré, Paris, IdF 75008, FRA'"
    })
    void testToString(String streetName, int streetNumber, String cityName, String cityZipCode, String state, String country, String completeAddress) {
        Address address = new Address(streetName,streetNumber,cityName,cityZipCode,state,country);
        Assertions.assertThat(address).as("Adresse").hasToString(completeAddress);
    }
}