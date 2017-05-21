package mylab.entities;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "platforms")
public class Platform implements Serializable {
    private long id;
    private String name;
    private String company;
    private String controller;
    private String store;
    
    public Platform () {}
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCompany() {
        return company;
    }
 
    public void setCompany(String company) {
        this.company = company;
    }
    
    public String getController() {
        return controller;
    }
 
    public void setController(String controller) {
        this.controller = controller;
    }
    
    public String getStore() {
        return store;
    }
 
    public void setStore(String store) {
        this.store = store;
    }
}
