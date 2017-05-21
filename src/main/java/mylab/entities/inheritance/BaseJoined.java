package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "base_joined")
public class BaseJoined implements Serializable {
    private long id;
    private String baseField;
    
    public BaseJoined() {}
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    @Column(nullable = true)
    public String getBaseField() {
        return baseField;
    }
 
    public void setBaseField(String baseField) {
        this.baseField = baseField;
    }   
    
    
}