public class Main {
    public static void main(String[] args) {
        CarRent rentalSystem = new CarRent();

        Car car1 = new Car("C01", "Toyota", "Camry", 60.0); // Different base price per day for each car
        Car car2 = new Car("C02", "Honda", "Accord", 70.0);
        Car car3 = new Car("C03", "Mahindra", "Thar", 150.0);
        Car car4 = new Car("C04", "Ford", "Mustang", 120.0);
        Car car5 = new Car("C05", "Maruti", "Suzuki", 80.0);
        Car car6 = new Car("C06", "Nissan", "Altima", 75.0);
        Car car7 = new Car("C07", "Hyundai", "Tucson", 90.0);

        SUV S1 = new SUV("Suv01", "Mahindra", "Scorpio", 150.56);
        SUV S2 = new SUV("Suv02", "Mahindra", "Thar", 200);

        LUX L1 = new LUX("Lux01", "BMW", "X5", 200.0);
        LUX L2 = new LUX("Lux02", "Mercedes-Benz", "E-Class", 180.0);
        LUX L3 = new LUX("Lux03", "Audi", "Q7", 220.0);

        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);
        rentalSystem.addCar(car7);

        rentalSystem.addCar(S1);
        rentalSystem.addCar(S2);

        rentalSystem.addCar(L1);
        rentalSystem.addCar(L2);
        rentalSystem.addCar(L3);

        
        rentalSystem.menu();
    }
}
