package mylab.dataproviders;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class HsqlDataProvider extends DataProvider {

    private static HsqlDataProvider _instance = null;
    public static HsqlDataProvider getInstance() {
        if (_instance == null) {
            _instance = new HsqlDataProvider();
        }
        return _instance;
    }
    
    private HsqlDataProvider() {
        super("hsql");
    }

    private String getDBName() {
        return (String)this.getSessionFactory().getProperties().get("hibernate.connection.datebase_name");
    }
    
    @Override
    public List<String> getTableNames() {
        Session session = this.getSessionFactory().openSession();
  
        List<String> lst = session.createNamedQuery("HQL_GET_TABLE_NAMES")
                .list();

        if (session.isOpen()) {
            session.close();
        }       
        
        return lst;
    }


    @Override
    public Double getDbSize() {
        throw new NotImplementedException();
    }

    @Override
    public List<String> getUserNames() {
        Session session = this.getSessionFactory().openSession();
       
        List<String> users = session.createNamedQuery("HQL_GET_USER_NAMES")
                .list();

        if (session.isOpen()) {
            session.close();
        }       
                   
        return users;
    }

    @Override
    public String getVersion() {
        throw new NotImplementedException();
    }
    
   
}
