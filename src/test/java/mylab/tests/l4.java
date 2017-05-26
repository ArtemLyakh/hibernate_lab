package mylab.tests;

import java.io.Serializable;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.*;
import mylab.entities.collections.*;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class l4 {
    
    public l4() { }
    
    private static DataProvider dataProvider;
    
    @BeforeClass
    public static void setUpClass() {
        dataProvider = MysqlDataProvider.getInstance();
    }    
    @AfterClass
    public static void tearDownClass() {
    }
    
    private Session session;
    private static Serializable id;
    
    @Before
    public void setUp() {
        session = dataProvider.getSession();
    }
    
    @After
    public void tearDown() {
        session.close();
    }

    
    
    @Test
    public void Test1() {
        OuterEntity outer = new OuterEntity();
        
        outer.setStringField("stringField");
        
        outer.getStringList().add("value");
        outer.getStringList().add("value");
        outer.getStringList().add("new value");
        
        outer.getStringSet().add("value1");
        outer.getStringSet().add("value2");
        outer.getStringSet().add("value3");
            
        outer.getStringMap().put("key1", "value1");
        outer.getStringMap().put("key2", "value2");
        outer.getStringMap().put("key3", "value3");
        
        
        InnerEntity i1 = new InnerEntity();
        i1.setIntField(1);
        i1.setStringField("1");
        InnerEntity i2 = new InnerEntity();
        i2.setIntField(2);
        i2.setStringField("2");
        InnerEntity i3 = new InnerEntity();
        i3.setIntField(3);
        i3.setStringField("3");
        InnerEntity i4 = new InnerEntity();
        i4.setIntField(4);
        i4.setStringField("5");
        InnerEntity i5 = new InnerEntity();
        i5.setIntField(5);
        i5.setStringField("5");
        InnerEntity i6 = new InnerEntity();
        i6.setIntField(6);
        i6.setStringField("6");
        InnerEntity i7 = new InnerEntity();
        i7.setIntField(7);
        i7.setStringField("7");
        InnerEntity i8 = new InnerEntity();
        i8.setIntField(8);
        i8.setStringField("8");
        InnerEntity i9 = new InnerEntity();
        i9.setIntField(9);
        i9.setStringField("9");
        
        outer.getInnerEntityList().add(i1);
        outer.getInnerEntityList().add(i2);
        outer.getInnerEntityList().add(i3);
        
        outer.getInnerEntityMap().put(1, i4);
        outer.getInnerEntityMap().put(2, i5);
        outer.getInnerEntityMap().put(3, i6);
        
        outer.getInnerEntitySet().add(i7);
        outer.getInnerEntitySet().add(i8);
        outer.getInnerEntitySet().add(i9);
        
        session.beginTransaction();       
        id = session.save(outer);
        session.getTransaction().commit();
        
        assertNotNull(id);
    }
    
    public void Test2() {
        OuterEntity outer = session.get(OuterEntity.class, id);
        assertNotNull(outer);
        
        assertEquals(outer.getStringList().size(), 3);
        assertFalse(outer.getStringSet().isEmpty());
        assertTrue(outer.getStringMap().containsKey("key1"));
        assertTrue(outer.getStringMap().containsValue("value2"));
        
        assertEquals(outer.getInnerEntityList().size(), 3);
        assertFalse(outer.getInnerEntitySet().isEmpty());
  
        InnerEntity i8 = new InnerEntity();
        i8.setIntField(8);
        i8.setStringField("8");
        assertTrue(outer.getInnerEntityMap().get(8).equals(i8));
        
    }
    
    public void Test3() {
        OuterEntity outer = new OuterEntity();
        outer.setId((long)id);
        
        session.beginTransaction();
        session.delete(outer);
        session.getTransaction().commit();
        
        CriteriaQuery<OuterEntity> cq = session.getCriteriaBuilder().createQuery(OuterEntity.class);
        cq.from(OuterEntity.class);
        assertTrue(session.createQuery(cq).getResultList().isEmpty());
    }
    
}
