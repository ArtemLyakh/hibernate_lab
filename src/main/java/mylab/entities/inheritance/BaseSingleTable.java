package mylab.entities.inheritance;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "base_single_table")
public class BaseSingleTable implements Serializable {
    private long id;
    private String baseField;
    
    public BaseSingleTable() {}
    
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