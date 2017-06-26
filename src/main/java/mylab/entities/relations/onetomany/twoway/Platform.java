package mylab.entities.relations.onetomany.twoway;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "platform_otm2w")
@Table(name = "l5_otm_2w_platform")
public class Platform implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    
    @Column(name = "name")
    protected String name;
    
    @OneToMany(
            mappedBy = "platform",
            cascade = CascadeType.ALL
    )
    protected Set<Game> games = new HashSet<>();

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Platform other = (Platform) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.games, other.games)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Platform{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
}
