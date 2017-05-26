package mylab.entities.collections;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
@Table(name = "l4_outer_entity")
public class OuterEntity implements Serializable {
    
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
    private Set<String> stringSet = new HashSet<>();

    @ElementCollection
    @CollectionTable(
            name = "l4_parent_string_list",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @OrderColumn(name = "parent_id_order")
    @Column(name = "list_value")
    private List<String> stringList = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_string_map",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @MapKeyColumn(name = "map_key")
    @Column(name = "map_value")
    private Map<String, String> stringMap = new HashMap<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_child_set",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    private Set<InnerEntity> innerEntitySet = new HashSet<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_child_list",
            joinColumns = @JoinColumn(name = "parent_id")
    )    
    @OrderColumn(name = "parent_id_order")
    private List<InnerEntity> innerEntityList = new ArrayList<>();
    
    @ElementCollection
    @CollectionTable(
            name = "l4_parent_child_map",
            joinColumns = @JoinColumn(name = "parent_id")
    )
    @MapKeyColumn(name = "map_key")
    private Map<Integer, InnerEntity> innerEntityMap = new HashMap<>();
    
    
    
    
    public OuterEntity() { }

    public long getId() {
        return id;
    }

    public String getStringField() {
        return stringField;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public Map<String, String> getStringMap() {
        return stringMap;
    }

    public Set<InnerEntity> getInnerEntitySet() {
        return innerEntitySet;
    }

    public List<InnerEntity> getInnerEntityList() {
        return innerEntityList;
    }

    public Map<Integer, InnerEntity> getInnerEntityMap() {
        return innerEntityMap;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setStringField(String stringField) {
        this.stringField = stringField;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setStringMap(Map<String, String> stringMap) {
        this.stringMap = stringMap;
    }

    public void setInnerEntitySet(Set<InnerEntity> innerEntitySet) {
        this.innerEntitySet = innerEntitySet;
    }

    public void setInnerEntityList(List<InnerEntity> innerEntityList) {
        this.innerEntityList = innerEntityList;
    }

    public void setInnerEntityMap(Map<Integer, InnerEntity> innerEntityMap) {
        this.innerEntityMap = innerEntityMap;
    }



    
}
