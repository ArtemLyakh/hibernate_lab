package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Session;

@Entity
@Table(name = "l3_child_table_per_class")
public class ChildTablePerClass extends BaseTablePerClass {
    
    @Column(name = "child_field")
    protected String childField;
   
    
    
    public ChildTablePerClass() { }
    
    public String getChildField() {
        return childField;
    }  
    public void setChildField(String childField) {
        this.childField = childField;
    } 
 
    
    @Override
    public boolean load(Session session, Serializable id) {
        try {
            ChildTablePerClass loaded = session.get(ChildTablePerClass.class, id);
            
            this.id = loaded.getId();
            this.baseField = loaded.getBaseField();
            this.childField = loaded.getChildField();
                    
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
}
