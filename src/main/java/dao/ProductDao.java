package dao;

import entities.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.List;

public class ProductDao implements IProductDao{

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
        return null;
    }

    @Override
    public Product removeProduct(Product product) throws Exception {
        return null;
    }

    @Override
    public Product getProductById(int id) throws Exception {
        return null;
    }

    @Override
    public List<Product> getProducts() throws Exception {
        return null;
    }
}
