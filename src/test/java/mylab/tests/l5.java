package mylab.tests;

import java.io.Serializable;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.*;
import mylab.entities.relations.manytomany.Tournament;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class l5 {
    private static final Logger log = Logger.getLogger(l5.class.getName());
    
    private static DataProvider dataProvider;
    private Session session;
    
    
    public l5() { }
    
    @BeforeClass
    public static void setUpClass() {
        dataProvider = MysqlDataProvider.getInstance();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        session = dataProvider.getSession();
    }
    
    @After
    public void tearDown() {
        session.close();
    }
    

    
    
    @Test
    public void OneToManyOneWay() {
        mylab.entities.relations.onetomany.oneway.Platform platform 
                = new mylab.entities.relations.onetomany.oneway.Platform();
        platform.setName("test_platform");
               
        session.beginTransaction();
        Serializable platrormId = session.save(platform);
        session.getTransaction().commit();
        
        assertNotNull(platrormId);
        
        
        
        mylab.entities.relations.onetomany.oneway.Game game 
                = new mylab.entities.relations.onetomany.oneway.Game();
        game.setName("test_game");
        game.setGenre("test_genre");
        game.setPlatform(platform);
        
        session.beginTransaction();
        Serializable gameId = session.save(game);
        session.getTransaction().commit();
        
        assertNotNull(gameId);
        
        
        
        mylab.entities.relations.onetomany.oneway.Platform readedPlatform 
                = session.get(mylab.entities.relations.onetomany.oneway.Platform.class, platrormId);
        assertNotNull(readedPlatform);
        assertTrue(readedPlatform.equals(platform));
        
        mylab.entities.relations.onetomany.oneway.Game readedGame 
                = session.get(mylab.entities.relations.onetomany.oneway.Game.class, gameId);
        assertNotNull(readedGame);
        assertNotNull(readedGame.getPlatform());
        assertTrue(readedGame.getPlatform().equals(platform));
        assertTrue(readedGame.equals(game));
        
    }
    
    @Test
    public void OneToManyTwoWay() {
        mylab.entities.relations.onetomany.twoway.Platform platform 
                = new mylab.entities.relations.onetomany.twoway.Platform();
        platform.setName("test_platform");
        
        session.beginTransaction();
        Serializable platformId = session.save(platform);
        session.getTransaction().commit();
        
        assertNotNull(platformId);
        
        mylab.entities.relations.onetomany.twoway.Game game1
                = new mylab.entities.relations.onetomany.twoway.Game();
        game1.setName("name1");
        game1.setGenre("genre1");
        game1.setPlatform(platform);
        
        session.beginTransaction();
        Serializable game1Id = session.save(game1);
        session.getTransaction().commit();
        
        assertNotNull(game1Id);
        
        session.beginTransaction();
        
        mylab.entities.relations.onetomany.twoway.Game game2
                = new mylab.entities.relations.onetomany.twoway.Game();
        game2.setName("name2");
        game2.setGenre("genre2");
        game2.setPlatform(platform);
        
        platform.getGames().add(game2);

        session.getTransaction().commit();

        
        CriteriaQuery<mylab.entities.relations.onetomany.twoway.Game> cq 
                = session.getCriteriaBuilder().createQuery(mylab.entities.relations.onetomany.twoway.Game.class);
        cq.from(mylab.entities.relations.onetomany.twoway.Game.class);
        List<mylab.entities.relations.onetomany.twoway.Game> gamesList
                = session.createQuery(cq).getResultList();
        
        
        assertEquals(gamesList.size(), 2);
        
    }
    
    
    @Test
    public void OneToOneSharedKey() {
        
        mylab.entities.relations.onotoone.sharedkey.Game game 
                = new mylab.entities.relations.onotoone.sharedkey.Game();
        
        mylab.entities.relations.onotoone.sharedkey.Tournament tournament
                = new mylab.entities.relations.onotoone.sharedkey.Tournament();
        
        tournament.setName("tournamet");
        tournament.setGame(game);
        
        game.setName("game");
        game.setGenre("genre");
        game.setTournament(tournament);
        
        session.beginTransaction();
        Serializable sharedId = session.save(game);
        session.getTransaction().commit();   
        assertNotNull(sharedId);
        
        mylab.entities.relations.onotoone.sharedkey.Game readedGame 
                = session.get(mylab.entities.relations.onotoone.sharedkey.Game.class, sharedId);
        assertNotNull(readedGame);
        
        mylab.entities.relations.onotoone.sharedkey.Tournament readedTournament
                = session.get(mylab.entities.relations.onotoone.sharedkey.Tournament.class, sharedId);
        assertNotNull(readedTournament);
        
        assertTrue(readedTournament.getGame().equals(readedGame));
    }
    
    
    @Test
    public void OneToOneForeignKey() {
        mylab.entities.relations.onotoone.foreignkey.Game game 
                = new mylab.entities.relations.onotoone.foreignkey.Game();
        
        mylab.entities.relations.onotoone.foreignkey.Tournament tournament
                = new mylab.entities.relations.onotoone.foreignkey.Tournament();
        
        
        game.setName("game");
        game.setGenre("genre");
        
        tournament.setName("tournament");
        tournament.setGame(game);

        game.setTournament(tournament);
        
        session.beginTransaction();
        Serializable gId = session.save(game);
        Serializable tId = session.save(tournament);
        session.getTransaction().commit();
        assertNotNull(gId);
        assertNotNull(tId);
        
        mylab.entities.relations.onotoone.foreignkey.Game readedGame 
                = session.get(mylab.entities.relations.onotoone.foreignkey.Game.class, gId);
        assertNotNull(readedGame);
        
        mylab.entities.relations.onotoone.foreignkey.Tournament readedTournament
                = session.get(mylab.entities.relations.onotoone.foreignkey.Tournament.class, tId);
        assertNotNull(readedTournament);
        

        assertTrue(readedGame.getTournament().equals(readedTournament));
        assertTrue(readedTournament.getGame().equals(readedGame));
        

    }
    
    
    
    @Test
    public void ManyToMant() {
        mylab.entities.relations.manytomany.Game game1 
                = new mylab.entities.relations.manytomany.Game();
        game1.setName("g1");
        game1.setGenre("g1");
        
        mylab.entities.relations.manytomany.Game game2 
                = new mylab.entities.relations.manytomany.Game();
        game2.setName("g2");
        game2.setGenre("g2");
        
        mylab.entities.relations.manytomany.Tournament tournament1 
                = new mylab.entities.relations.manytomany.Tournament();
        tournament1.setName("t1");
        
        mylab.entities.relations.manytomany.Tournament tournament2 
                = new mylab.entities.relations.manytomany.Tournament();
        tournament2.setName("t2");
        
        
        game1.getTournaments().add(tournament1);
        game1.getTournaments().add(tournament2);
        
        game2.getTournaments().add(tournament1);
        game2.getTournaments().add(tournament2);
        
        tournament1.getGames().add(game1);
        tournament1.getGames().add(game2);
        
        tournament2.getGames().add(game1);
        tournament2.getGames().add(game2);
        
        
        
        session.beginTransaction();       
        Serializable t1 = session.save(tournament1);
        Serializable t2 = session.save(tournament2);
        Serializable g1 = session.save(game1);
        Serializable g2 = session.save(game2);
        session.getTransaction().commit();
        
        assertNotNull(g1);
        assertNotNull(g2);
        assertNotNull(t1);
        assertNotNull(t2);
        
        
        
        mylab.entities.relations.manytomany.Game readedGame1 
                = session.get(mylab.entities.relations.manytomany.Game.class, g1);
        assertNotNull(readedGame1);
        
        mylab.entities.relations.manytomany.Game readedGame2
                = session.get(mylab.entities.relations.manytomany.Game.class, g2);
        assertNotNull(readedGame2);
        
        mylab.entities.relations.manytomany.Tournament readedTournament1 
                = session.get(mylab.entities.relations.manytomany.Tournament.class, t1);
        assertNotNull(readedTournament1);
        
        mylab.entities.relations.manytomany.Tournament readedTournament2
                = session.get(mylab.entities.relations.manytomany.Tournament.class, t2);
        assertNotNull(readedTournament2);
        
//        readedGame1.getTournaments().forEach((t) -> {
//            log.info(t.hashCode());
//        });  
//        log.info(readedTournament1.hashCode());
//        log.info(readedTournament2.hashCode());
//        log.info(readedGame1.getTournaments().contains(readedTournament1));




//        assertTrue(readedGame1.getTournaments().contains(readedTournament1));
//        assertTrue(readedGame1.getTournaments().contains(readedTournament2));
//        
//        assertTrue(readedGame2.getTournaments().contains(readedTournament1));
//        assertTrue(readedGame2.getTournaments().contains(readedTournament2));
//        
//        assertTrue(readedTournament1.getGames().contains(readedGame1));
//        assertTrue(readedTournament1.getGames().contains(readedGame2));
//        
//        assertTrue(readedTournament2.getGames().contains(readedGame1));
//        assertTrue(readedTournament2.getGames().contains(readedGame2));


        boolean contains;
        
        
        contains = false;
        for (mylab.entities.relations.manytomany.Tournament t : readedGame1.getTournaments()) {
            if (t.hashCode() == readedTournament1.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);

        
        contains = false;
        for (mylab.entities.relations.manytomany.Tournament t : readedGame1.getTournaments()) {
            if (t.hashCode() == readedTournament2.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
        
        contains = false;
        for (mylab.entities.relations.manytomany.Tournament t : readedGame2.getTournaments()) {
            if (t.hashCode() == readedTournament1.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
        
        contains = false;
        for (mylab.entities.relations.manytomany.Tournament t : readedGame2.getTournaments()) {
            if (t.hashCode() == readedTournament2.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
        
        contains = false;
        for (mylab.entities.relations.manytomany.Game g : readedTournament1.getGames()) {
            if (g.hashCode() == readedGame1.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
        
        contains = false;
        for (mylab.entities.relations.manytomany.Game g : readedTournament1.getGames()) {
            if (g.hashCode() == readedGame2.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);

        
        contains = false;
        for (mylab.entities.relations.manytomany.Game g : readedTournament2.getGames()) {
            if (g.hashCode() == readedGame1.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);
        
        contains = false;
        for (mylab.entities.relations.manytomany.Game g : readedTournament2.getGames()) {
            if (g.hashCode() == readedGame2.hashCode()) {
                contains = true;
                break;
            }
        }
        assertTrue(contains);       
    }
}
