package service;

import model.customer.Customer;

import java.util.ArrayList;
import java.util.Collection;

public class CustomerService {
    private static final CustomerService instance = new CustomerService();
    private final Collection<Customer> customers = new ArrayList<>();

    private CustomerService() {
    }

    public void addCustomer(String email, String firstName, String lastName) {
        try {
            Customer existingCustomer = getCustomer(email);
            if (existingCustomer != null) {
                System.out.println("Customer already exists");
                return;
            }
            Customer customer = new Customer(firstName, lastName, email);
            customers.add(customer);
        } catch (Exception e) {
            System.out.println("Invalid data for account creation");
        }
    }

    public Customer getCustomer(String customerEmail) {
        for (Customer customer : customers) {
            if (customer.getEmail().equals(customerEmail)) {
                return customer;
            }
        }
        return null;
    }

    public Collection<Customer> getAllCustomers() {
        return customers;
    }

    public static CustomerService getInstance() {
        return instance;
    }
}
