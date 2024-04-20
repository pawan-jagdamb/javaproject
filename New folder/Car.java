interface Rentable {
    double calculatePriceOfRent(int noOfDays);
}

class Car implements Rentable {
    // creatiing a class of car that have following property
    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean Available;

    /*
     * all property are declared a private because we don't show it outside the
     * class (Encapsulation)
     */
    public Car(String carId, String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.basePricePerDay = basePricePerDay;
        this.Available = true;
    }

    // using getter for getting value
    public String getCarId() {
        return carId;

    }

    public boolean Available() {
        return Available;
    }

    public String getBrand() {
        return brand;

    }

    public String getModel() {
        return model;
    }

    public double getbasePricePerDay() {
        return basePricePerDay;
    }

    // using a overridden method to calculate price of rent
    @Override
    public double calculatePriceOfRent(int noOfDay) {
        return (double) noOfDay * basePricePerDay;
    }

    // using a method what will mark false if car is not available
    public void rent() {
        Available = false;
    }

    // this method will mark true if car is returned;
    public void returnCar() {
        Available = true;
    }

}

class SUV extends Car {
    // Using Inheritance and using same car class to add Suv vehicle
    public SUV(String carId, String brand, String model, double basePricePerDay) {
        super(carId, brand, model, basePricePerDay);
    }

}

class LUX extends Car {
    // Using Inheritance and using same car class to add LUX vehicle
    public LUX(String carId, String brand, String model, double basePricePerDay) {
        super(carId, brand, model, basePricePerDay);
    }
}
