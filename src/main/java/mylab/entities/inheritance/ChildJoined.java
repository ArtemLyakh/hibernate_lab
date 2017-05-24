package mylab.entities.inheritance;

import javax.persistence.*;

@Entity
@Table(name = "l3_child_joined")
public class ChildJoined extends BaseJoined {
    
    @Column(name = "child_field")
    private String childField;
    
    
    
    public ChildJoined() { }
    
    public String getChildField() {
        return childField;
    }    
    public void setChildField(String childField) {
        this.childField = childField;
    }
    
}
