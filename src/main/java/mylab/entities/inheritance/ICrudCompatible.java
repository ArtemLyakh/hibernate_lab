package mylab.entities.inheritance;

import java.io.Serializable;
import org.hibernate.Session;


public interface ICrudCompatible {
    boolean save(Session session);
    boolean update(Session session);
    boolean load(Session session, Serializable id);
    boolean delete(Session session);
}
