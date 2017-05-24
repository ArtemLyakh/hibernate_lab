package mylab.entities.inheritance;

import javax.persistence.*;

@Entity
public class ChildSingleTable extends BaseSingleTable {
    
    @Column(name = "child_field")
    private String childField;
    
    
    
    public ChildSingleTable() { }
    
    public String getChildField() {
        return childField;
    }  
    public void setChildField(String childField) {
        this.childField = childField;
    }
    
}
