package metier;

import entities.Customer;
import entities.Product;

import java.util.List;

public interface ICustomerMetier {
    Customer subscribe(Customer customer) throws Exception;
    Customer updateProfile(Customer customer) throws Exception;
    Customer getCustomerById(Long id) throws Exception;
    Customer deleteCustomer(Long id) throws Exception;
    List<Customer> getCustomers() throws Exception;
    void buyProduct(Long id, String ref) throws Exception;
}
