package dao;

import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateCrud;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IProductDao{

    private HibernateCrud<Product,String> crud = new HibernateCrud<>();

    @Override
    public Product addProduct(Product product) throws Exception {
        return crud.add(product);
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        return crud.update(product);
    }

    @Override
    public Product removeProduct(Product product) throws Exception {
        return crud.delete(product);
    }

    @Override
    public Product getProductByRef(String ref) throws Exception {
        return crud.getById(ref, "ref", Product.class.getName());
    }

    @Override
    public List<Product> getProducts() throws Exception {
        return crud.getAll(Product.class.getName());
    }

    /*
    private SessionFactory factory = HibernateUtil.getFactory();
    private Session session;

    @Override
    public Product addProduct(Product product) throws Exception {
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.save(product); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return product;
    }

    @Override
    public Product updateProduct(Product product) throws Exception {
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.update(product); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return product;
    }

    @Override
    public Product removeProduct(Product product) throws Exception {
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.delete(product); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return product;
    }

    @Override
    public Product getProductByRef(String ref) throws Exception {
        Product product = null;
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            product = session.get(Product.class,ref); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return product;
    }

    @Override
    public List<Product> getProducts() throws Exception {
        List<Product> products = new ArrayList<Product>();
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            products = session.createQuery("from Product p",Product.class).getResultList(); // HQL
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return products;
    }*/
}
