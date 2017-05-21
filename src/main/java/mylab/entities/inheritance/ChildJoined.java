package mylab.entities.inheritance;

import javax.persistence.*;

@Entity(name = "child_joined")
public class ChildJoined extends BaseJoined {
    private String childField;
    
    public String getChildField() {
        return childField;
    }
    
    public void setChildField(String childField) {
        this.childField = childField;
    }
}
