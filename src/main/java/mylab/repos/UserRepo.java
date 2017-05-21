package mylab.repos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.DataProvider;
import mylab.entities.User;
import org.hibernate.Session;

public class UserRepo {
    private final DataProvider _dp;
    
    public UserRepo(DataProvider dp) {
        this._dp = dp;
    }
    
    public List<User> getList() {
        Session session = _dp.getSession();
         
        CriteriaQuery<User> cq = session.getCriteriaBuilder().createQuery(User.class);
        cq.from(User.class);
        List<User> list = session.createQuery(cq).getResultList();
        
        session.close();
        
        return list;
    }
    
    public User getById(long id) {
        Session session = _dp.getSession();
        
        User book = session.get(User.class, id);
        
        session.close();
        
        return book;
    }
    
    public Long create(User platform) {
        Session session = _dp.getSession();
        session.beginTransaction();
        try {           
            Serializable res = session.save(platform);
            session.getTransaction().commit();
            return (Long)res;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return null;
        } finally {           
            session.close();
        }
    }
    
    public boolean update(User platform) {
        Session session = _dp.getSession();
        session.beginTransaction();
        try {           
            session.update(platform);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }       
    }
    
    public boolean delete(User platform) {
        Session session = _dp.getSession();
        session.beginTransaction();
        try {           
            session.delete(platform);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            session.getTransaction().commit();
            session.close();
        }          
    }    
}
