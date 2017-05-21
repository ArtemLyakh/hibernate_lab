package mylab.dataproviders;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class DataProvider {
    public abstract List<String> getTableNames();
    public abstract Double getDbSize();
    public abstract List<String> getUserNames();
    public abstract String getVersion();
    
    public DataProvider(String dataProviderName) {
        this._sessionFactory = HibernateUtils.getSessionFactory(dataProviderName);
    }
    
    private final SessionFactory _sessionFactory;
    protected final SessionFactory getSessionFactory() {      
        return this._sessionFactory;
    }

    
    public Session getSession() {
        return this.getSessionFactory().openSession();
    }
    
    @Override
    protected void finalize() throws Throwable {
        this._sessionFactory.close();
        super.finalize();
    }
}
