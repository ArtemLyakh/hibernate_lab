package mylab.entities.inheritance;

import javax.persistence.*;

@Entity(name = "child_table_per_class")
public class ChildTablePerClass extends BaseTablePerClass {
    private String childField;
   
    public String getChildField() {
        return childField;
    }
    
    public void setChildField(String childField) {
        this.childField = childField;
    }   
}
