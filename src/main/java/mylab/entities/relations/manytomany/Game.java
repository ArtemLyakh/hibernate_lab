package mylab.entities.relations.manytomany;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "game_mtm")
@Table(name = "l5_mtm_game")
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected long id;
  
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "l5_mtm_game_tournament",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tournament_id")
    )
    private Set<Tournament> tournaments = new HashSet<>();
    
    @Column(name = "name")
    protected String name;
    
    @Column(name = "genre")
    protected String genre;

    public Game() {}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(Set<Tournament> tournaments) {
        this.tournaments = tournaments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.genre);
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
        final Game other = (Game) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.genre, other.genre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Game{" + "id=" + id + ", name=" + name + ", genre=" + genre + '}';
    }
    
    
    
}
