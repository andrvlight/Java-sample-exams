package rental.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import rental.CarRental;
import rental.Car;

public class CarRentalTest1 {

    static CarRental carRental1;
    static CarRental carRental2;

    @BeforeAll
    public static void init() {
        carRental1 = new CarRental("cars.txt");
        carRental2 = new CarRental("cars.txt");
    }

    @Test
    public void testToString() {
        String expected = 
        "BMW (ABC 123)  50,0 EUR\n" +
        "Alfa Romeo (DEF 234)   9,0 EUR\n" +
        "Toyota (GHI 456) 500,0 EUR\n" +
        "Volvo (JSD 856) 500,0 EUR\n";

        assertEquals(expected, carRental1.toString());
    }

    @Test
    public void testInsertionSort() {
        carRental1.insertionSort();

        String expected = 
        "Alfa Romeo (DEF 234)   9,0 EUR\n" +
        "BMW (ABC 123)  50,0 EUR\n" +
        "Toyota (GHI 456) 500,0 EUR\n" +
        "Volvo (JSD 856) 500,0 EUR\n";

        assertEquals(expected, carRental1.toString());
    }

    @Test
    public void testWeightedAverage() {
        double expected = 356.8;

        double actual = carRental1.weightedAverage();
        assertEquals(expected, actual);
    }

    @Test 
    public void testRentCheapest() {
        Car expected = Car.make("Alfa Romeo", "DEF 234", 9);

        assertEquals (expected.toString(), carRental2.rentCheapest().toString());
    }
}
