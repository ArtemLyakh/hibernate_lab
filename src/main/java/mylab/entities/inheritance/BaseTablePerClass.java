package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Session;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "l3_base_table_per_class")
public class BaseTablePerClass implements Serializable, ICrudCompatible {
     
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    
    @Column(name = "base_field", nullable = true)
    protected String baseField;
    
    
    
    public BaseTablePerClass() {}
    
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
            BaseTablePerClass loaded = session.get(BaseTablePerClass.class, id);
            
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