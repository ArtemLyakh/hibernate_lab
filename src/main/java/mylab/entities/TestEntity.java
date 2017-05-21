package mylab.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "test_entity")
public class TestEntity implements Serializable {

    private long id;
    private String name;
    private String description;
    private Date dateCreated;
    private boolean isCheck;
    private TestEntityEmbeded embeded1;
    private TestEntityEmbeded embeded2;
    
    public TestEntity() {}
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }   
    public void setId(long id) {
        this.id = id;
    }
    
    @Column
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    @Column
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column
    @Temporal(javax.persistence.TemporalType.DATE)
    public Date getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    
    @Column
    public boolean getIsCheck() {
        return isCheck;
    }
    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "stringField", column = @Column(name = "stringField1")),
        @AttributeOverride(name = "intField", column = @Column(name = "intField1"))
    })
    public TestEntityEmbeded getEmbeded1() {
        return embeded1;
    }
    public void setEmbeded1(TestEntityEmbeded embeded1) {
        this.embeded1 = embeded1;
    }
    
    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "stringField", column = @Column(name = "stringField2")),
        @AttributeOverride(name = "intField", column = @Column(name = "intField2"))
    })
    public TestEntityEmbeded getEmbeded2() {
        return embeded2;
    }
    public void setEmbeded2(TestEntityEmbeded embeded2) {
        this.embeded2 = embeded1;
    }
}
