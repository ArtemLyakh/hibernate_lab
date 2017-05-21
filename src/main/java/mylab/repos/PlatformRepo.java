package mylab.repos;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.DataProvider;
import mylab.entities.Platform;
import org.hibernate.Session;

public class PlatformRepo {
    private final DataProvider _dp;
    
    public PlatformRepo(DataProvider dp) {
        this._dp = dp;
    }
    
    public List<Platform> getList() {
        Session session = _dp.getSession();
         
        CriteriaQuery<Platform> cq = session.getCriteriaBuilder().createQuery(Platform.class);
        cq.from(Platform.class);
        List<Platform> list = session.createQuery(cq).getResultList();
        
        session.close();
        
        return list;
    }
    
    public Platform getById(long id) {
        Session session = _dp.getSession();
        
        Platform book = session.get(Platform.class, id);
        
        session.close();
        
        return book;
    }
    
    public Long create(Platform platform) {
        Session session = _dp.getSession();
        session.beginTransaction();
        try {           
            return (Long)session.save(platform);
        } catch (Exception e) {
            return null;
        } finally {
            session.getTransaction().commit();
            session.close();
        }
    }
    
    public boolean update(Platform platform) {
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
    
    public boolean delete(Platform platform) {
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
