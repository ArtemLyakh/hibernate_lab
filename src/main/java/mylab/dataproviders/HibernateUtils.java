package mylab.dataproviders;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HibernateUtils {
    public static SessionFactory getSessionFactory(String db) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg."+db+".xml") // configures settings from hibernate.cfg.xml
                .build();
        try {
            return new MetadataSources(registry)
                    .addResource("hibernate.queries."+db+".xml")
                    .buildMetadata()
                    .buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
            throw ex;
        }
    }
}
