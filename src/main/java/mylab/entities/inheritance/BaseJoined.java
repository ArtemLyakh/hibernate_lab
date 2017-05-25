package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Session;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "l3_base_joined")
public class BaseJoined implements Serializable, ICrudCompatible {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    protected long id;
    
    @Column(name = "base_field", nullable = true)
    protected String baseField;
  
    
    
    public BaseJoined() {}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getBaseField() {
        return baseField;
    }
    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }  

    @Override
    public boolean save(Session session) {
        session.beginTransaction();
        
        try {
            session.save(this);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean update(Session session) {
        session.beginTransaction();
        
        try {
            session.update(this);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }
    }

    @Override
    public boolean load(Session session, Serializable id) {
        try {
            BaseJoined loaded = session.get(BaseJoined.class, id);
            
            this.id = loaded.getId();
            this.baseField = loaded.getBaseField();
                    
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public boolean delete(Session session) {
        session.beginTransaction();
        
        try {
            session.delete(this);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            return false;
        }   
    }
    
}