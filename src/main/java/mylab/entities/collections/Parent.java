package mylab.entities.collections;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "l4_parent")
public class Parent implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "string_field", nullable = false)
    private String stringField;

    @ElementCollection
    @CollectionTable(
            name = "l4_parent_string_set",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @Column(name = "set_value")
    private final Set<String> stringSet = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "l4_parent_string_list",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @OrderColumn(name = "parent_id_order")
    @Column(name = "list_value")
    private final List<String> stringList = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_string_map",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @MapKeyColumn(name = "map_key")
    @Column(name = "map_value")
    private final Map<String, String> stringMap = new HashMap<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_child_set",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    private final Set<Child> childSet = new HashSet<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_child_list",
            joinColumns = @JoinColumn(name = "parent_id")
    )    
    @OrderColumn(name = "parent_id_order")
    private final List<Child> childList = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_child_map",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @MapKeyColumn(name = "map_key")
    private final Map<Integer, Child> childMap = new HashMap<>();
    
    
    
    
    public Parent() { }
    
    public long getId() {
        return id;
    }  
    public void setId(long id) {
        this.id = id;
    }
    
    public String getStringField() {
        return stringField;
    }
    public void setStringField(String stringField) {
        this.stringField = stringField;
    }       
      
    public Set<String> getSringSet() {
        return stringSet;
    }
    
    public List<String> getStringList() {
        return stringList;
    }
    
    public Map<String, String> getStringMap() {
        return stringMap;
    }
    
    public Set<Child> getChildSet() {
        return childSet;
    }
    
    public List<Child> getChildList() {
        return childList;
    }
    
    public Map<Integer, Child> getChildMap() {
        return childMap;       
    }
    
}
