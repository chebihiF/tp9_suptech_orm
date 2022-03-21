package test;

import dao.CustomerDao;
import dao.ProductDao;
import entities.Customer;
import entities.Product;
import util.HibernateUtil;

public class Test {
    public static void main(String[] args) {
        ProductDao daoP = new ProductDao();
        CustomerDao daoC = new CustomerDao();

        try {
            Customer customer = daoC.getCustomerById(1L);
            daoP.addProduct(new Product("R001","IphoneXXX",14000,100,customer));
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
