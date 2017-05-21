package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "base_table_per_class")
public class BaseTablePerClass implements Serializable {
    private long id;
    private String baseField;
    
    public BaseTablePerClass() {}
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
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