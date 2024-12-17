package service;

import model.customer.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerService {
    private static final Collection<Customer> customers = new ArrayList<>();
    public static void addCustomer(String email, String firstName, String lastName) {
        try {
            Customer customer = new Customer(firstName, lastName, email);
            customers.add(customer);
        } catch (Exception e) {
            System.out.println("Invalid data for account creation");
        }
    }

    public static Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }

    public static Collection<Customer> getAllCustomers() {
        return customers;
    }
}
