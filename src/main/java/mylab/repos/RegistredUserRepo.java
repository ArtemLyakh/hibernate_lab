package mylab.repos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.DataProvider;
import mylab.entities.RegistredUser;
import org.hibernate.Session;

public class RegistredUserRepo {
    private final DataProvider _dp;
    
    public RegistredUserRepo(DataProvider dp) {
        this._dp = dp;
    }
    
    public List<RegistredUser> getList() {
        Session session = _dp.getSession();
         
        CriteriaQuery<RegistredUser> cq = session.getCriteriaBuilder().createQuery(RegistredUser.class);
        cq.from(RegistredUser.class);
        List<RegistredUser> list = session.createQuery(cq).getResultList();
        
        session.close();
        
        return list;
    }
    
    public RegistredUser getById(long id) {
        Session session = _dp.getSession();
        
        RegistredUser book = session.get(RegistredUser.class, id);
        
        session.close();
        
        return book;
    }
    
    public Long create(RegistredUser platform) {
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
    
    public boolean update(RegistredUser platform) {
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
    
    public boolean delete(RegistredUser platform) {
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
