package rental.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import rental.CarRental;

public class CarRentalTest1 {

    @Test
    public void testToString() {
        String expected = 
        "BMW (ABC 123)  50,0 EUR\n" +
        "Alfa Romeo (DEF 234)   9,0 EUR\n" +
        "Toyota (GHI 456) 500,0 EUR\n" +
        "Volvo (JSD 856) 500,0 EUR\n";
        CarRental carRental = new CarRental("cars.txt");

        assertEquals(expected, carRental.toString());
    }
}
