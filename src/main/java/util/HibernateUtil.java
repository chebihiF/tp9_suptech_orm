package util;


import entities.Customer;
import entities.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory factory;

    static{
        factory = new Configuration().configure()
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public static SessionFactory getFactory() {
        return factory;
    }
}
