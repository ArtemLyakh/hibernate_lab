package mylab.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class TestEntityEmbeded implements Serializable {
    
    @Column(name = "string_field")
    private String stringField;
    
    @Column(name = "int_field")
    private int intField;
  
    
    
    
    public TestEntityEmbeded() { }   
    
    public String getStringField() {
        return stringField;
    }
    public void setStringField(String stringField) {
        this.stringField = stringField;
    }
      
    public int getIntField() {
        return intField;
    }
    public void setIntField(int intField) {
        this.intField = intField;
    }   
}
