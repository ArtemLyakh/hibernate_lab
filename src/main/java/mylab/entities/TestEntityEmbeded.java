package mylab.entities;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class TestEntityEmbeded implements Serializable {
    
    private String stringField;
    private int intField;
    
    @Column
    public String getStringField() {
        return stringField;
    }
    public void setStringField(String stringField) {
        this.stringField = stringField;
    }
    
    @Column
    public int getIntField() {
        return intField;
    }
    public void setIntField(int intField) {
        this.intField = intField;
    }   
}
