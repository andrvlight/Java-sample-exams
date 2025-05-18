package rental;

public class Car {

    private String brand;
    private String licensePlate;
    private double price;
    private static final double MAX_PRICE = 500;
    private static final Car CAR_OF_THE_YEAR = new Car("Alfa Romeo", "ABC 123", MAX_PRICE);

    private Car (String brand, String licensePlate, double price) {
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.price = price;
    } 
}