package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.Session;

@Entity
public class ChildSingleTable extends BaseSingleTable {
    
    @Column(name = "child_field")
    protected String childField;
    
    
    
    public ChildSingleTable() { }
    
    public String getChildField() {
        return childField;
    }  
    public void setChildField(String childField) {
        this.childField = childField;
    }
    
    @Override
    public boolean load(Session session, Serializable id) {
        try {
            ChildSingleTable loaded = session.get(ChildSingleTable.class, id);
            
            this.id = loaded.getId();
            this.baseField = loaded.getBaseField();
            this.childField = loaded.getChildField();
                    
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
    
}
