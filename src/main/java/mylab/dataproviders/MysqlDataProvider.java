package mylab.dataproviders;

import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;

public class MysqlDataProvider extends DataProvider {

    private static MysqlDataProvider _instance = null;
    public static MysqlDataProvider getInstance() {
        if (_instance == null) {
            _instance = new MysqlDataProvider();
        }
        return _instance;
    }
    
    private MysqlDataProvider() {
        super("mysql");
    }

    private String getDBName() {
        return (String)this.getSessionFactory().getProperties().get("hibernate.connection.datebase_name");
    }
    
    @Override
    public List<String> getTableNames() {
        Session session = this.getSessionFactory().openSession();
        
        List<String> lst = session.createNamedQuery("HQL_GET_TABLE_NAMES")
                .setParameter("dbname", this.getDBName())
                .list();

        if (session.isOpen()) {
            session.close();
        }       
        
        return lst;
    }

    @Override
    public Double getDbSize() {
        Session session = this.getSessionFactory().openSession();

        Double size = ((BigDecimal)session.createNamedQuery("HQL_GET_DB_SIZE")
                .setParameter("dbname", this.getDBName())
                .uniqueResult())
                .doubleValue();
            
        if (session.isOpen()) {
            session.close();
        }  
        
        return size;
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
        Session session = this.getSessionFactory().openSession();
        
        String version = session.createNamedQuery("HQL_GET_DB_VERSION")
                    .uniqueResult()
                    .toString();
        
        if (session.isOpen()) {
            session.close();
        }       
                   
        return version;
    }
    
   
}
