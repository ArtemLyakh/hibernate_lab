package mylab.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.*;
import mylab.entities.inheritance.BaseJoined;
import mylab.entities.inheritance.BaseSingleTable;
import mylab.entities.inheritance.BaseTablePerClass;
import mylab.entities.inheritance.ChildJoined;
import mylab.entities.inheritance.ChildSingleTable;
import mylab.entities.inheritance.ChildTablePerClass;
import mylab.entities.inheritance.ICrudCompatible;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class l3 {
    
    private static final Logger LOG = Logger.getLogger(l3.class.getName());
    
    public l3() { }
    
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
    
    
    @Test
    public void Test() {
        List<ICrudCompatible> crudList = new ArrayList<>();
        
        BaseSingleTable baseSingleTable = new BaseSingleTable();
        baseSingleTable.setBaseField("baseField");
        crudList.add(baseSingleTable);
        
        ChildSingleTable childSingleTable = new ChildSingleTable();
        childSingleTable.setBaseField("baseField");
        childSingleTable.setChildField("childField");
        crudList.add(childSingleTable);
        
        BaseJoined baseJoined = new BaseJoined();
        baseJoined.setBaseField("baseField");
        crudList.add(baseJoined);
        
        ChildJoined childJoined = new ChildJoined();
        childJoined.setBaseField("baseField");
        childJoined.setChildField("childField");
        crudList.add(childJoined);
        
        BaseTablePerClass baseTablePerClass = new BaseTablePerClass();
        baseTablePerClass.setBaseField("baseField");
        crudList.add(baseTablePerClass);
        
        ChildTablePerClass childTablePerClass = new ChildTablePerClass();
        childTablePerClass.setBaseField("baseField");
        childTablePerClass.setChildField("childField");
        crudList.add(childTablePerClass);        
        
        
        crudList.forEach(el -> assertTrue(el.save(session)));     
        
                    
        CriteriaQuery<BaseSingleTable> cqBaseSingleTable = session.getCriteriaBuilder().createQuery(BaseSingleTable.class);
        cqBaseSingleTable.from(BaseSingleTable.class);
        CriteriaQuery<ChildSingleTable> cqChildSingleTable = session.getCriteriaBuilder().createQuery(ChildSingleTable.class);
        cqChildSingleTable.from(ChildSingleTable.class);       
        CriteriaQuery<BaseJoined> cqBaseJoined = session.getCriteriaBuilder().createQuery(BaseJoined.class);
        cqBaseJoined.from(BaseJoined.class);
        CriteriaQuery<ChildJoined> cqChildJoined = session.getCriteriaBuilder().createQuery(ChildJoined.class);
        cqChildJoined.from(ChildJoined.class);
        CriteriaQuery<BaseTablePerClass> cqBaseTablePerClass = session.getCriteriaBuilder().createQuery(BaseTablePerClass.class);
        cqBaseTablePerClass.from(BaseTablePerClass.class);
        CriteriaQuery<ChildTablePerClass> cqChildTablePerClass = session.getCriteriaBuilder().createQuery(ChildTablePerClass.class);
        cqChildTablePerClass.from(ChildTablePerClass.class);        
        

        assertEquals(session.createQuery(cqBaseSingleTable).getResultList().size(), 2);
        assertEquals(session.createQuery(cqChildSingleTable).getResultList().size(), 1);
        assertEquals(session.createQuery(cqBaseJoined).getResultList().size(), 2);
        assertEquals(session.createQuery(cqChildJoined).getResultList().size(), 1);
        assertEquals(session.createQuery(cqBaseTablePerClass).getResultList().size(), 2);
        assertEquals(session.createQuery(cqChildTablePerClass).getResultList().size(), 1);
       
        crudList.forEach(el -> assertTrue(el.delete(session)));
        
        assertEquals(session.createQuery(cqBaseSingleTable).getResultList().size(), 0);
        assertEquals(session.createQuery(cqChildSingleTable).getResultList().size(), 0);
        assertEquals(session.createQuery(cqBaseJoined).getResultList().size(), 0);
        assertEquals(session.createQuery(cqChildJoined).getResultList().size(), 0);
        assertEquals(session.createQuery(cqBaseTablePerClass).getResultList().size(), 0);
        assertEquals(session.createQuery(cqChildTablePerClass).getResultList().size(), 0);
    }
    
    
}
