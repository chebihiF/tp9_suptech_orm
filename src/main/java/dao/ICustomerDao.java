package dao;

import entities.Customer;

import java.util.List;

public interface ICustomerDao {
    Customer addCustomer(Customer customer) throws Exception;
    Customer updateCustomer(Customer customer) throws Exception;
    Customer deleteCustomer(Customer customer) throws Exception;
    Customer getCustomerById(Long id) throws Exception;
    List<Customer> getCustomers() throws Exception;
}
