package driver;

import model.customer.Customer;

public class Driver {

    public static void main(String[] args) {
        Customer customer = new Customer("John", "Doe", "abc@gmail.com");
        System.out.println(customer);
        Customer customer2 = new Customer("Jane", "Doe", "abc");
    }
}
