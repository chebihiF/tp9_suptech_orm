package dao;

import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao{

    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session;

    @Override
    public Customer addCustomer(Customer customer) throws Exception {
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            Long id = (Long) session.save(customer); // sql : insert into ...
            customer.setId(id);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            if(session != null) session.close();
        }
        return customer;
    }

    @Override
    public Customer updateCustomer(Customer customer) throws Exception {
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.update(customer); // sql : update customer set ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            if(session != null) session.close();
        }
        return customer;
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws Exception {
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.delete(customer); // sql : delete customer set ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            if(session != null) session.close();
        }
        return customer;
    }

    @Override
    public Customer getCustomerById(Long id) throws Exception {
        Customer customer = null;
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            customer = session.get(Customer.class,id);
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            if(session != null) session.close();
        }
        return customer;
    }

    @Override
    public List<Customer> getCustomers() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            customers = session.createQuery("from Customer c",Customer.class).getResultList(); // HQL
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
        }finally{
            if(session != null) session.close();
        }
        return customers;
    }
}
