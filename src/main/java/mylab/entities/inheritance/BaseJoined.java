package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "l3_base_joined")
public class BaseJoined implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)   
    private long id;
    
    @Column(name = "base_field", nullable = true)
    private String baseField;
  
    
    
    public BaseJoined() {}
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    
    public String getBaseField() {
        return baseField;
    }
    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }  
    
}