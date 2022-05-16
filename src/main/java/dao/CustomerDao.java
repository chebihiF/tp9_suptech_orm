package dao;

import entities.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateCrud;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class CustomerDao implements ICustomerDao{

	private HibernateCrud<Customer, Long> crud = new HibernateCrud<Customer, Long>();
	
	@Override
	public Customer addCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return crud.add(customer);
	}

	@Override
	public Customer updateCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return crud.update(customer);
	}

	@Override
	public Customer deleteCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		return crud.delete(customer);
	}

	@Override
	public Customer getCustomerById(Long id) throws Exception {
		// TODO Auto-generated method stub
		return crud.getById(id, "id");
	}

	@Override
	public Customer getCustomerByEmail(String email) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> getCustomers() throws Exception {
		// TODO Auto-generated method stub
		return crud.getAll();
	}
	
	
	

    /*
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
            throw e;
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
            throw e;
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
            throw e;
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
            throw e;
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
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return customers;
    }

	@Override
	public Customer getCustomerByEmail(String email) throws Exception {
		Customer customer = null;
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            //HQL => classes 
            customer = session.createQuery("from Customer c where c.email='"+email+"'",
            		Customer.class).getSingleResult();
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw new Exception("email not found");
        }finally{
            if(session != null) session.close();
        }
        return customer;
	} */
}
