package mylab.entities.relations.onetomany.oneway;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity(name = "game_otm1w")
@Table(name = "l5_otm_1w_game")
public class Game implements Serializable {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    
    @Column(name = "name")
    protected String name;
    
    @Column(name = "genre")
    protected String genre;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "platform", nullable = false)
    protected Platform platform;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGenre() {
        return genre;
    }

    public Platform getPlatform() {
        return platform;
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

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 41 * hash + Objects.hashCode(this.name);
        hash = 41 * hash + Objects.hashCode(this.genre);
        hash = 41 * hash + Objects.hashCode(this.platform);
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
        if (!Objects.equals(this.platform, other.platform)) {
            return false;
        }
        return true;
    }
    
    
    
}
