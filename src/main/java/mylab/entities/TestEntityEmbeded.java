package mylab.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class TestEntityEmbeded implements Serializable {

    @Override
    public String toString() {
        return "TestEntityEmbeded{" + "stringField=" + stringField + ", intField=" + intField + '}';
    }
    
    @Column(name = "string_field")
    private String stringField;
    
    @Column(name = "int_field")
    private int intField;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.stringField);
        hash = 31 * hash + this.intField;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestEntityEmbeded other = (TestEntityEmbeded) obj;
        if (this.intField != other.intField) {
            return false;
        }
        if (!Objects.equals(this.stringField, other.stringField)) {
            return false;
        }
        return true;
    }
  
    
    
    
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
