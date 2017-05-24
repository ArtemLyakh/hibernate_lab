package mylab.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "l2_test_entity")
public class TestEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description")
    private String description;
    
    @Column(name = "date_created")
    @Temporal(javax.persistence.TemporalType.DATE)    
    private Date dateCreated;
    
    @Column(name = "is_check")    
    private boolean isCheck;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
                name = "stringField", 
                column = @Column(name = "string_field_1")
        ),
        @AttributeOverride(
                name = "intField",
                column = @Column(name = "int_field_1")
        )
    })    
    private TestEntityEmbeded embeded1;
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(
                name = "stringField", 
                column = @Column(name = "string_field_2")
        ),
        @AttributeOverride(
                name = "intField", 
                column = @Column(name = "int_field_2")
        )
    })    
    private TestEntityEmbeded embeded2;
 
    
    
    
    public TestEntity() {}  

    public long getId() {
        return id;
    }   
    public void setId(long id) {
        this.id = id;
    }
       
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    public boolean getIsCheck() {
        return isCheck;
    }
    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }
    
    public TestEntityEmbeded getEmbeded1() {
        return embeded1;
    }
    public void setEmbeded1(TestEntityEmbeded embeded1) {
        this.embeded1 = embeded1;
    }
    
    public TestEntityEmbeded getEmbeded2() {
        return embeded2;
    }
    public void setEmbeded2(TestEntityEmbeded embeded2) {
        this.embeded2 = embeded1;
    }

}
