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

    public double getPrice() {
        return this.price;
    }

    public boolean isCheaperThan (Car other) {
        return this.price < other.getPrice();
    } 

    public void decreasePrice () {
        if (this.price > 10 && this.price != this.MAX_PRICE)
            this.price -= 10;
    }

    public static boolean isValidLicensePlate (String licensePlate) {
        if (licensePlate == null || licensePlate.length() != 7) 
            return false;
        
        for (int i = 0; i < 3; i++) 
            if (!Character.isUpperCase(licensePlate.charAt(i)) || !(Character.isLetter(licensePlate.charAt(i))))
                return false;

        for (int i = 4; i < 7; i++) 
            if (!Character.isDigit(licensePlate.charAt(i)))
                return false;
            
        if (!(licensePlate.charAt(3) == ' '))
                return false;

        return true;
    }

    public static Car make (String brand, String licensePlate, double price) {
        if (brand.length() < 2)
            return null;

        for (int i = 0; i < brand.length(); i++) 
            if (Character.isDigit(brand.charAt(i)))
                return null;

        if (!isValidLicensePlate(licensePlate))
            return null;

        if (price <= 0 || price > MAX_PRICE)
            return null;

        Car car = new Car (brand, licensePlate, price);
        return car;
    }

    @Override
    public String toString() {
        return "%s (%s) %5.1f EUR".formatted(this.brand, this.licensePlate, this.price);
    }
}