package rental.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rental.Car;

public class CarTest {

    @Test
    public void testGetPrice() {
        Car car = Car.make ("BMW", "ABC 123", 400);
        assertEquals(400, car.getPrice());
    }

    @ParameterizedTest
    @CsvSource({
        "BMW, ABC 123, 400",
        "BMW, ABC 123, 100",
        "BMW, ABC 123, 500",
        "BMW, ABC 123, 200"
    })
    public void testIsCheaper (String brand, String licensePlate, double price) {
        Car car1 = Car.make ("BMW", "ABC 123", 400);
        Car car2 = Car.make (brand, licensePlate, price);

        if (price <= 400)
            assertFalse(car1.isCheaperThan(car2));
        else 
            assertTrue(car1.isCheaperThan(car2));
    }

    @ParameterizedTest
    @CsvSource ({
        "BMW, ABC 123, 10",
        "BMW, ABC 123, 9",
        "BMW, ABC 123, 500",
        "BMW, ABC 123, 400"
    })
    public void testDecreasePrice(String brand, String licensePlate, double price) {
        Car car = Car.make (brand, licensePlate, price);
        car.decreasePrice();

        if (price == 500 || price <= 10)
            assertEquals(price, car.getPrice());
        else 
            assertEquals(price - 10, car.getPrice());
    }

    @ParameterizedTest
    @CsvSource ({
        "ABCD 123",
        "ABC  123",
        "ABC 1234",
        "aBc 123",
        "ABC a12",
        "ABC1 23",
        "ABC 123",
        "A,BC 123"
    })
    public void testIsValidLicensePlate (String licensePlate) {
        boolean invalid = 
        (licensePlate == null)
        ||(licensePlate.length() != 7)
        ||(licensePlate.charAt(3) != ' ')
        || !(Character.isUpperCase(licensePlate.charAt(0))
            && Character.isUpperCase(licensePlate.charAt(1))
            && Character.isUpperCase(licensePlate.charAt(2)))
        || !(Character.isDigit(licensePlate.charAt(4))
            && Character.isDigit(licensePlate.charAt(5))
            && Character.isDigit(licensePlate.charAt(6)));

        if (invalid)
            assertFalse(Car.isValidLicensePlate(licensePlate));
        else
            assertTrue(Car.isValidLicensePlate(licensePlate));
    }

    @ParameterizedTest
    @CsvSource ({
        "A, ABC 123, 100",
        "BMV2, ABC 123, 100",
        "BMW, ABCD 123, 300",
        "BMW, ABC  123, 300",
        "BMW, ABC 1234, 300",
        "BMW, aBc 123, 300",
        "BMW, ABC a12, 300",
        "BMW, ABC1 23, 300",
        "BMW, ABC 123, 501",
        "BMW, ABC 123, -100",
        "BMW, ABC 123, 100"
    })
    public void testMake (String brand, String licensePlate, double price) {
        Car car = Car.make (brand, licensePlate, price);
        
        boolean invalid = 
            (brand.length() < 2)
            || (brand.chars().anyMatch(Character::isDigit))
            || (!Car.isValidLicensePlate(licensePlate))
            || (price < 0 || price > 500);

        if (invalid)
            assertNull(car);
        else
            assertNotNull(car);
    }

    @Test
    public void TestToString() {
        String brand = "BMW";
        String licensePlate = "ABC 123";
        double  price = 100;

        Car car = Car.make(brand, licensePlate, price);
        assertEquals("BMW (ABC 123) 100,0 EUR", car.toString());
    }
}