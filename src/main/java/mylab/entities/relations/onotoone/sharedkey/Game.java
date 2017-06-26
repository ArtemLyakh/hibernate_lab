package mylab.entities.relations.onotoone.sharedkey;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity(name = "game_oto_sk")
@Table(name = "l5_oto_sk_game")
public class Game implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "poi_seq_poiid_generator")
    @SequenceGenerator(name = "poi_seq_poiid_generator", sequenceName = "poi_seq_poiid", allocationSize = 1)
    @Column(name = "game_id")
    protected long id;
  
    
    @OneToOne(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
    private Tournament tournament;
    
    
    
    
    @Column(name = "name")
    protected String name;
    
    @Column(name = "genre")
    protected String genre;
    
    public Game() {}

    public long getId() {
        return id;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 71 * hash + Objects.hashCode(this.name);
        hash = 71 * hash + Objects.hashCode(this.genre);
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
