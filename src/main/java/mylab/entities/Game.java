package mylab.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String genre;
    private int rating;

    public Game() {}
    
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

    public String getGenre() {
        return genre;
    }
 
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public int getRating() {
        return rating;
    }
 
    public void setRating(int rating) {
        this.rating = rating;
    }
    
    @ElementCollection
    @CollectionTable(name = "game_prices", joinColumns = @JoinColumn(name = "id"))
    public Set<Integer> prices = new HashSet<Integer>();
    
}
