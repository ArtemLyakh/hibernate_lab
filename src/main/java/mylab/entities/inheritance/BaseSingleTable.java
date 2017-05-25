package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Session;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "l3_base_single_table")
public class BaseSingleTable implements Serializable, ICrudCompatible {
    
    @Id 
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)    
    protected long id;
    
    @Column(name = "base_field", nullable = true)
    protected String baseField;
    
    
    
    
    public BaseSingleTable() {}

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
            BaseSingleTable loaded = session.get(BaseSingleTable.class, id);
            
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