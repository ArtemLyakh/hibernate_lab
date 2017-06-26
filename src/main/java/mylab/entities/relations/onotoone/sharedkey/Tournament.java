package mylab.entities.relations.onotoone.sharedkey;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;


@Entity(name = "tournament_oto_sk")
@Table(name = "l5_oto_sk_tournament")
public class Tournament implements Serializable {
    
    
    @Column(name = "name")
    protected String name;
    
    @Id
    @OneToOne
    @JoinColumn(name = "game_id")
    protected Game game;
 
    
    
    
    
    public Tournament() {}


    public String getName() {
        return name;
    }

    public Game getGame() {
        return game;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.game);
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
        return "Tournament{" + "name=" + name + ", game=" + game + '}';
    }


    
    
    
}
