package mylab.entities.relations.manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "tournament_mtm")
@Table(name = "l5_mtm_tournament")
public class Tournament implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected long id;
    
    @Column(name = "name")
    protected String name;
    
    @Id
    @ManyToMany(mappedBy = "tournaments")
    protected Set<Game> games = new HashSet<>();
    
    
    public Tournament() {}

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

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 17 * hash + Objects.hashCode(this.name);
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
        final Tournament other = (Tournament) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tournament{" + "id=" + id + ", name=" + name + '}';
    }
    
    
    
    
}
