package com.basic.exer1;

public class Bank {

    private final Customer[] customers;
    private int numberOfCustomers;

    public Bank() {
        customers = new Customer[10];
    }

    public void addCustomer(String f, String l) {
        Customer cust = new Customer(f, l);
        customers[numberOfCustomers++] = cust;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];
        }
        return null;
    }
}
