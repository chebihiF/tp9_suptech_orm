package metier;

import dao.CustomerDao;
import dao.ICustomerDao;
import dao.IProductDao;
import dao.ProductDao;
import entities.Customer;
import entities.Product;

import java.util.List;

public class CustomerMetier implements ICustomerMetier {

    private ICustomerDao dao = new CustomerDao();
    private IProductDao Pdao = new ProductDao();

    @Override
    public Customer subscribe(Customer customer) throws Exception {
        if(!customer.getEmail().toLowerCase().contains("gmail"))
            throw new Exception("email invalid");
        if(customer.getName().isEmpty())
            throw new Exception("name cannot be empty");
        return dao.addCustomer(customer);
    }

    @Override
    public Customer updateProfile(Customer customer) throws Exception {
        if(!customer.getEmail().toLowerCase().contains("gmail"))
            throw new Exception("email invalid");
        if(customer.getName().isEmpty())
            throw new Exception("name cannot be empty");
        if(customer.getId() == null)
            throw new Exception("ID cannot be NULL");
        return dao.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long id) throws Exception {
        if(id == null)
            throw new Exception("ID cannot be NULL");
        return dao.getCustomerById(id);
    }

    @Override
    public Customer deleteCustomer(Long id) throws Exception {
        if(id == null)
            throw new Exception("ID cannot be NULL");
        return dao.deleteCustomer(dao.getCustomerById(id));
    }

    @Override
    public List<Customer> getCustomers() throws Exception {
        return dao.getCustomers();
    }

    @Override
    public void buyProduct(Long id,String ref) throws Exception {
        Customer customer = dao.getCustomerById(id);
        Product product = Pdao.getProductByRef(ref);
        product.setCustomer(customer);
        Pdao.updateProduct(product);
    }

}
