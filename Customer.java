public class Customer extends Person {
    private int customerId;

    public Customer(String name, String email, int customerId) {
        super(name, email);
        this.customerId = customerId;
    }

    @Override
    public void display() {
        System.out.println("Customer ID: " + customerId + " - Name: " + name);
    }

    public int getCustomerId() {
        return 0;
    }
}
