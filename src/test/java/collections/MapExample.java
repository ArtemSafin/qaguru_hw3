package collections;

import java.util.HashMap;

public class MapExample {

    public final HashMap<String, Integer> retroCars = new HashMap<>();

    public void getCars(HashMap<String, Integer> retroCars) {
        retroCars.forEach((brand, year) -> System.out.println("brand: " + brand + ", year: " + year));
    }
    public void addCar(String brand, int year) {
        retroCars.put(brand, year);
    }
    public void addIfAbsentCar(String brand, int year) {
        retroCars.putIfAbsent(brand, year);
    }
    public void removeCar(String brand) {
        retroCars.remove(brand);
    }
    public void getCar(String brand) {
        retroCars.get(brand);
    }

    public static void main(String[] args) {

        MapExample mapExample = new MapExample();
        mapExample.addCar("Volkswagen", 1950);
        mapExample.addCar("Чайка", 1959);
        mapExample.addCar("Cadillac", 1957);
        mapExample.addIfAbsentCar("Mercedes", 1955);
        mapExample.addIfAbsentCar("Buick", 1959);
        mapExample.addIfAbsentCar("Chevrolet", 1960);

        mapExample.getCar("Buick");
        mapExample.removeCar("Чайка");

        mapExample.getCars(mapExample.retroCars);

    }
}
