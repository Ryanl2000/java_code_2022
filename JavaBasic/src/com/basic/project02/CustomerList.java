package com.basic.project02;

public class CustomerList {

    private Customer[] customers;
    private int total = 0;

    public CustomerList(int totalCustomer) {
        customers = new Customer[totalCustomer];
    }


    public boolean addCustomer(Customer customer) {
        if (getTotal() < customers.length) {
            customers[total++] = customer;
            return true;
        } else {
            System.out.println("成员已满");
            return false;
        }
    }

    public Customer getCustomer(int index) {
        if (index < 0 || index >= total) {
            return null;
        }
        return customers[index];
    }

    public boolean replaceCustomer(int index, Customer cust) {
        if (getTotal() < index + 1) {
            System.out.println("索引无效");
            return false;
        } else {
            customers[index] = cust;
            return true;
        }
    }

    public boolean deleteCustomer(int index) {
        if (getTotal() < index + 1) {
            System.out.println("索引无效");
            return false;
        }
        for (int i = index; i < total - 1; i++) {
            customers[i] = customers[i + 1];
        }
        customers[--total] = null;
        return true;
    }

    public Customer[] getAllCustomers() {
        Customer[] custs = new Customer[total];
        for (int i = 0; i < total; i++) {
            custs[i] = customers[i];
        }
        return custs;
    }

    public int getTotal() {
        return total;
    }

}
