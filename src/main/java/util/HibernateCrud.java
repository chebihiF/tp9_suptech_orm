package util;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class HibernateCrud<T, ID> {
	
	private SessionFactory factory = HibernateUtil.getFactory();
    private Session session;
    
    public T add(T t) {
    	try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.save(t); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return t;
    }
   
    public T update(T t) {
    	try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.update(t); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return t;
    }
    
    public T delete(T t) {
    	try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();
            session.delete(t); // sql : insert into ...
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return t;
    }

    public T getById(ID id, String id_name, String className) {
    	T t = null;
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();

            Query<T> q = session.createQuery("from "+className+" t where t."+id_name+" = ?");
            q.setParameter(0, id);
            
            t = (T) q.getSingleResult();
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return t;
    }

    public List<T> getAll(String className){
    	 List<T> ts = new ArrayList();
        try {
            if (session != null && session.isOpen())
                session = factory.getCurrentSession();
            else
                session = factory.openSession();
            session.beginTransaction();      
            ts = session.createQuery("from "+className).getResultList();
            session.getTransaction().commit();
        }catch(Exception e){
            session.getTransaction().rollback();
            throw e;
        }finally{
            if(session != null) session.close();
        }
        return ts;
    }
}
