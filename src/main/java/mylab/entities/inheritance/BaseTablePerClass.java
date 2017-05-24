package mylab.entities.inheritance;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "l3_base_table_per_class")
public class BaseTablePerClass implements Serializable {
     
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "base_field", nullable = true)
    private String baseField;
    
    
    
    public BaseTablePerClass() {}
    
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