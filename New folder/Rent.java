class Rent {
    private Car car;
    private Customer customer;
    private int noOfDays;

    // using constructor to initialize the Rent values
    public Rent(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.noOfDays = days;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int days() {
        return noOfDays;
    }

}
