package mylab.entities.inheritance;

import javax.persistence.*;

@Entity
public class ChildSingleTable extends BaseSingleTable {
    private String childField;
    
    public String getChildField() {
        return childField;
    }
    
    public void setChildField(String childField) {
        this.childField = childField;
    }   
}
