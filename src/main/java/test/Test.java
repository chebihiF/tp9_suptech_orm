package test;

import dao.CustomerDao;
import entities.Customer;
import util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        CustomerDao dao = new CustomerDao();
        try {
            Customer customer = dao.addCustomer(new Customer(null,"ahmed","ahmed@gmail.com",null));
            System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
