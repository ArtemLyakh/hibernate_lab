package mylab.repos;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.DataProvider;
import mylab.entities.Game;
import org.hibernate.Session;

public class GameRepo {
    private final DataProvider _dp;
    
    public GameRepo(DataProvider dp) {
        this._dp = dp;
    }
    
    public List<Game> getList() {
        Session session = _dp.getSession();
         
        CriteriaQuery<Game> cq = session.getCriteriaBuilder().createQuery(Game.class);
        cq.from(Game.class);
        List<Game> list = session.createQuery(cq).getResultList();
        
        session.close();
        
        return list;
    }
    
    public Game getById(long id) {
        Session session = _dp.getSession();
        
        Game book = session.get(Game.class, id);
        
        session.close();
        
        return book;
    }
    
    public Long create(Game platform) {
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
    
    public boolean update(Game platform) {
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
    
    public boolean delete(Game platform) {
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
