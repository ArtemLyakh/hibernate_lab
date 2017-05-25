package mylab.tests;

import java.util.logging.Level;
import java.util.logging.Logger;
import mylab.dataproviders.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author artem
 */
public class l1 {

    private static final Logger LOG = Logger.getLogger(l1.class.getName());
    
    public l1() {
    }
    
    private static DataProvider dataProvider;
    
    
    
    @BeforeClass
    public static void setUpClass() {
        dataProvider = MysqlDataProvider.getInstance();
    }  
    @AfterClass
    public static void tearDownClass() {
    }
    
    
    @Before
    public void setUp() {
    }   
    @After
    public void tearDown() {
    }


    @Test
    public void GetTables() {
        LOG.log(Level.INFO, "Database table list:\n{0}", String.join("\n", dataProvider.getTableNames()));
    }
    
    @Test
    public void GetSize() {
        LOG.log(Level.INFO, "Database size:\n{0}", dataProvider.getDbSize().toString());
    }
    
    @Test
    public void GetUsers() {
        LOG.log(Level.INFO, "Database user list:\n{0}", String.join("\n", dataProvider.getUserNames()));
    }
    
    @Test
    public void GetVersion () {
        LOG.log(Level.INFO, "Database version:\n{0}", dataProvider.getVersion());
    }
}
