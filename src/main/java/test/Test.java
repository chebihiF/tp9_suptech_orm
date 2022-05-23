package test;

import dao.CustomerDao;
import entities.Customer;
import metier.CustomerMetier;
import ui.Subscribe;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        CustomerMetier metier = new CustomerMetier();
        Customer customer = new Customer(null,"chebihi","Azerrty",
                "cheihi@gmail.com",null);
        try {
            //metier.saveInfoAsFile(customer);
            List<Customer> customers = metier.getCustomers();
            customers.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
