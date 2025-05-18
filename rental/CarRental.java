package rental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CarRental {

    private ArrayList<Car> cars;

    public CarRental (String filename) {
        try (Scanner scanner = new Scanner (new File (filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                try {
                    String[] cars = line.split(":");
                    if (cars.length != 2)
                        continue;
                    String brand = cars[0];

                    String[] platePrice = cars[1].split(",");
                    if (platePrice.length != 2)
                        continue;
                    String licensePlate = platePrice[0];
                    double price = platePrice[1];

                    Car car = Car.make(brand, licensePlate, price);
                    if (car != null)
                        this.cars.add(Car);
                } catch (Exception e) {

                }
            }
        } catch (FileNotFoundException e) {

        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars)
            sb.append(car.toString()).append("\n");

        return sb.toString();
    }
}