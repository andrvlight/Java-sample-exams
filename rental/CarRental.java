package rental;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

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
                    double price = Double.parseDouble(platePrice[1]);

                    Car car = Car.make(brand, licensePlate, price);
                    if (car != null)
                        this.cars.add(car);
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

    public void insertionSort() {
        for (int i = 1; i < this.cars.size(); i++) {
            Car pivot = cars.get(i);
            int j = i - 1;

            while (j>= 0 && pivot.isCheaperThan(cars.get(j))) {
                cars.set(j + 1, cars.get(j));
                j--;
            }

            cars.set(j + 1, pivot);
        }
    }

    public double weightedAverage () {
        if (this.cars.isEmpty())
            return -1;
        
        double weightedSum = 0;
        int weigthSum = 0;

        for (int i = 0; i < this.cars.size(); i++) {
            int weight = i + 1;
            weightedSum += this.cars.get(i).getPrice() * weight;
            weigthSum += weight;
        }

        return weightedSum / weigthSum;
    }

    public Car rentCheapest() {
        if (this.cars.isEmpty())
            return null;

        insertionSort();
        Car serched = this.cars.get(0);
        this.cars.remove(0);

        return serched;
    }

    public ArrayList<Car> sale() {
        Random random = new Random();
        ArrayList<Car> result = new ArrayList<>();

        for (Car car : cars) {
            if (random.nextBoolean()) {
                car.decreasePrice();
            }
            result.add(car);
        }

        return result;
    }
}