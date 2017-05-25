package mylab.tests;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.*;
import mylab.entities.TestEntity;
import mylab.entities.TestEntityEmbeded;
import org.hibernate.Session;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class l2 {

    private static final Logger LOG = Logger.getLogger(l2.class.getName());
    
    public l2() {
    }
    
    private static DataProvider dataProvider;
    
    @BeforeClass
    public static void setUpClass() {
        dataProvider = MysqlDataProvider.getInstance();
    }
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Session session;
    
    @Before
    public void setUp() {
        session = dataProvider.getSession();
    }
    @After
    public void tearDown() {
        session.close();
    }

    
    private static TestEntity checkEntity;
    private static Serializable id = null;
    
    @Test
    public void Test1() {
        TestEntity entity = new TestEntity();
        entity.setName("name");
        entity.setIsCheck(true);
        entity.setDescription("description");
        entity.setDateCreated(new Date(2000, 5, 5, 5, 5, 5));
        
        TestEntityEmbeded e1 = new TestEntityEmbeded();
        e1.setIntField(1);
        e1.setStringField("1");
        entity.setEmbeded1(e1);
        
        TestEntityEmbeded e2 = new TestEntityEmbeded();
        e2.setIntField(2);
        e2.setStringField("2");
        entity.setEmbeded2(e2);
        
        checkEntity = entity;      
        
        session.beginTransaction();       
        id = session.save(entity);       
        session.getTransaction().commit();
             
        assertNotNull(id);
    }
    
    @Test
    public void Test2() {
        TestEntity entity = session.get(TestEntity.class, id);
        
        LOG.log(Level.INFO, entity.toString());
        LOG.log(Level.INFO, checkEntity.toString());
        
        
        assertTrue(entity.equals(checkEntity));
        
        entity.setName("newname");
        
        session.beginTransaction();
        session.update(entity);
        session.getTransaction().commit();
        
        entity = session.get(TestEntity.class, entity.getId());
        assertFalse(entity.equals(checkEntity));

    }
    
    @Test
    public void Test3() {
        CriteriaQuery<TestEntity> cq = session.getCriteriaBuilder().createQuery(TestEntity.class);
        cq.from(TestEntity.class);
        List<TestEntity> list;
        
        list = session.createQuery(cq).getResultList();
        assertFalse(list.isEmpty());
        
        TestEntity entity = session.get(TestEntity.class, id);
        session.beginTransaction();
        session.delete(entity);
        session.getTransaction().commit();
        
        list = session.createQuery(cq).getResultList();
        assertTrue(list.isEmpty());
    }
}
