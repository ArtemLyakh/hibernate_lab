package mylab.entities.relations.onotoone.foreignkey;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Entity(name = "tournament_oto_fk")
@Table(name = "l5_oto_fk_tournament")
public class Tournament implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    protected long id;
    
    @Column(name = "name")
    protected String name;
    
    @Id
    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id")
    protected Game game;

    
    public Tournament() { }
    
    
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.game);
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
        if (!Objects.equals(this.game, other.game)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tournament{" + "id=" + id + ", name=" + name + ", game=" + game + '}';
    }
    
    
    
}
