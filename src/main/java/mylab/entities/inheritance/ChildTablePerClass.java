package mylab.entities.inheritance;

import javax.persistence.*;

@Entity
@Table(name = "l3_child_table_per_class")
public class ChildTablePerClass extends BaseTablePerClass {
    
    @Column(name = "child_field")
    private String childField;
   
    
    
    public ChildTablePerClass() { }
    
    public String getChildField() {
        return childField;
    }  
    public void setChildField(String childField) {
        this.childField = childField;
    } 
    
}
