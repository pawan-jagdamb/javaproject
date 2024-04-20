import java.util.*;

class CarRent {
    private List<Car> cars; // listing cars available for rent
    private List<Customer> customer; // listing customers who have rented cars
    private List<Rent> rent; // listing rent details for cars

    // Constructor
    public CarRent() {
        cars = new ArrayList<>();
        customer = new ArrayList<>();
        rent = new ArrayList<>();
    }

    // Method to add a car to the list of available cars
    public void addCar(Car car) {
        this.cars.add(car);
    }

    // Method to add a customer to the list of customers
    public void addCustomer(Customer customer) {
        this.customer.add(customer);
    }

    // Method to rent a car to a customer for a specified number of days
    public void rentCar(Car car, Customer customer, int days) {
        if (car.Available()) {
            car.rent();
            rent.add(new Rent(car, customer, days));

        } else {
            System.out.println(" Car is not available for rent");
        }
    }

    // Method to return a car to the list of available cars
    public void returnCar(Car car) {
        car.returnCar();
        Rent rentCartoRemove = null;

        for (Rent r : rent) {
            if (r.getCar() == car) {
                rentCartoRemove = r;
                break;
            }
        }
        if (rentCartoRemove != null) {
            rent.remove(rentCartoRemove);
            System.out.println("Car returned successfully");

        } else {
            // car.returnCar();
            System.out.println("Car was not rented");

        }
    }

    // Method to display the menu for the car rental system
    public void menu() {
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.println("------ Car Rental System ------");
                System.out.println("1. Rent a Car");
                System.out.println("2. Return a Car");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");

                String choice = sc.nextLine();
                System.out.println(""); // next line

                if (choice.equals("3")) {
                    System.out.println("Thank you for using the Car Rental System");
                    break;
                }

                switch (choice) {

                    case "1": {
                        System.out.println(" --- Rent a Car ---");
                        System.out.print("Enter your name: ");
                        String customerName = sc.nextLine();

                        System.out.print("Enter mobile no.:");
                        // long mobileNo = sc.nextLong();
                        long mobileNo = functionality.getValidMobileNo(sc);

                        System.out.print("Enter AADHAR no:");
                        // long aadhar = sc.nextLong();
                        long AadharNo = functionality.getValidAadharNo(sc);

                        System.out.print("Enter your address:");
                        // sc.nextLine();
                        String address = sc.nextLine();

                        System.out.println("-----------------------------------------");
                        System.out.println("Available Cars:");
                        // Print available cars and details
                        System.out.println("Car Id" + " - " + "Car name (price/day)");

                        // prints available cars for rent
                        for (Car car : cars) {
                            if (car.Available()) {
                                System.out.println(
                                        car.getCarId() + "-" + car.getBrand() + " " + car.getModel() + " " + "("
                                                + car.getbasePricePerDay() + ")");

                            }
                        }
                        System.out.println("-----------------------------------------");
                        System.out.print("\nEnter  the Car ID you want to rent \nElse Enter 0 for no rent or exit :");
                        String carId = sc.nextLine();
                        if (carId.equalsIgnoreCase("0")) {
                            break;
                        }
                        System.out.println("-----------------------------------------");
                        System.out.print("Enter the number of days you want for rent car :");
                        int rentDays = functionality.getValidDays(sc);
                        sc.nextLine();

                        Customer newCustomer = new Customer("CUS" + (customer.size() + 1), customerName, AadharNo,
                                mobileNo, address);
                        addCustomer(newCustomer);
                        Car selectedCar = null;
                        for (Car car : cars) {
                            if (car.getCarId().equalsIgnoreCase(carId) && car.Available()) {
                                selectedCar = car;
                                break;
                            }
                        }
                        if (selectedCar != null) {
                            double totalPrice = selectedCar.calculatePriceOfRent(rentDays);
                            System.out.println("\n---- Rental Information ----");
                            System.out.println("Customer ID: " + newCustomer.getCustomerId());
                            System.out.println("Customer Name: " + newCustomer.getName());
                            System.out.println("Car Id: " + selectedCar.getCarId());
                            System.out.println("Selected Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
                            System.out.println("Rental Days: " + rentDays);
                            System.out.printf("Total Price: ₹ %.4f\n", totalPrice);
                            System.out.println("-----------------------------------------");
                            System.out.println("Please confirm your rent (Y/N)");
                            String confirm = sc.nextLine();
                            // String confirm1 = confirm.toUpperCase();
                            if (confirm.equalsIgnoreCase("Y")) {
                                rentCar(selectedCar, newCustomer, rentDays);
                                System.out.println("***************************************");
                                System.out.println("\n Car Rented Successfully");
                                System.out.println("***************************************");

                            } else if (confirm.equalsIgnoreCase("N")) {
                                System.out.println("***************************************");
                                System.out.println("Car Rental canceled");
                                System.out.println("***************************************");

                            }
                            
                        }else {
                                System.out.println("--------------------------------------");
                                System.out.println("\n Invalid car selection ");
                                System.out.println("--------------------------------------");
                            }
                            break;
                    }
                

                    case "2": {
                        System.out.println("\n --- Return a Car ---");
                        System.out.print("Enter Car ID you want to return:");
                        String carId = sc.nextLine();

                        Car carToReturn = null;
                        for (Car car : cars) {
                            if (car.getCarId().equalsIgnoreCase(carId) && !car.Available()) {
                                carToReturn = car;
                                break;
                            }
                            if (car instanceof LUX && car.getCarId().equalsIgnoreCase(carId) && !car.Available()) {
                                carToReturn = car;
                                break;
                            }
                            if (car instanceof SUV && car.getCarId().equalsIgnoreCase(carId) && !car.Available()) {
                                carToReturn = car;
                                break;
                            }
                        }
                        if (carToReturn != null) {
                            Customer customer = null;
                            for (Rent r : rent) {
                                if (r.getCar() == carToReturn) {
                                    customer = r.getCustomer();
                                    break;
                                }
                            }
                            if (customer != null) {
                                returnCar(carToReturn);
                                System.out.println("Car Returned Successfully by");
                                System.out.println("Customer Id: " + customer.getCustomerId());
                                System.out.println("Customer Name: " + customer.getName());
                                System.out.println("Customer Mobile no: " + (long) customer.getMobile());
                                System.out.println("Customer AADHAR: " + (long) customer.getAadhar());
                                System.out.println("Customer address: " + customer.getAddress());
                            }

                            else {
                                System.out.println("Car was not rented or rental information is missing");

                            }
                        } else {
                            System.out.println("Invalid car ID or car is not rented");
                        }
                        break;
                    }

                    case "3": {
                        System.out.println("\n Thanks you for using the Car Rental System");
                        break;
                        
                    }

                    default: {
                        System.out.println("Invalid choice. Please enter a valid choice");
                        break;
                    }
                }
                
            }
        }
    }
}
