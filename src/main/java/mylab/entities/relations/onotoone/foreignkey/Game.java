package mylab.entities.relations.onotoone.foreignkey;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity(name = "game_oto_fk")
@Table(name = "l5_oto_fk_game")
public class Game implements Serializable {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected long id;
  
    
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "game")
    private Tournament tournament;
    
    @Column(name = "name")
    protected String name;
    
    @Column(name = "genre")
    protected String genre;

    
    public Game() { }
    
    
    public long getId() {
        return id;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 23 * hash + Objects.hashCode(this.name);
        hash = 23 * hash + Objects.hashCode(this.genre);
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
