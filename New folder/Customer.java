class Customer {
    private String customerId;
    private String name;
    private long aadhar;
    private long mobileNo;
    private String address;

    // Using constructor to initialize the value or property of customer
    public Customer(String customerId, String name, long aadhar, long mobileNo, String address) {
        this.customerId = customerId;
        this.name = name;
        this.aadhar = aadhar;
        this.mobileNo = mobileNo;
        this.address = address;

    }

    // Using getter to returning value or property or details of customer
    public String getCustomerId() {
        return this.customerId;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public long getAadhar() {
        return this.aadhar;
    }

    public long getMobile() {
        return this.mobileNo;
    }
}
