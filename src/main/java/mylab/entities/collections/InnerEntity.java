package mylab.entities.collections;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Embeddable
public class InnerEntity implements Serializable {
    
    @Column(name = "string_field", nullable = true)
    private String stringField;

    @Column(name = "int_field")
    private int intField;
    
    
    
    public InnerEntity() { }

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
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.stringField);
        hash = 29 * hash + this.intField;
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
        final InnerEntity other = (InnerEntity) obj;
        if (this.intField != other.intField) {
            return false;
        }
        if (!Objects.equals(this.stringField, other.stringField)) {
            return false;
        }
        return true;
    }
  
}
