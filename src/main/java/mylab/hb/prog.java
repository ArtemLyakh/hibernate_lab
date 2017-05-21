package mylab.hb;

import mylab.entities.inheritance.ChildTablePerClass;
import mylab.entities.inheritance.ChildJoined;
import mylab.entities.inheritance.ChildSingleTable;
import mylab.entities.inheritance.BaseTablePerClass;
import mylab.entities.inheritance.BaseSingleTable;
import mylab.entities.inheritance.BaseJoined;
import java.io.Console;
import java.util.Date;
import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import mylab.dataproviders.*;
import mylab.entities.*;
import mylab.repos.*;
import org.hibernate.Session;

public class prog {
    public static void main(String[] args) {
//        PlatformRepo pr = new PlatformRepo(MysqlDataProvider.getInstance());
//        GameRepo gr = new GameRepo(MysqlDataProvider.getInstance());
//        UserRepo ur = new UserRepo(MysqlDataProvider.getInstance());
//        RegistredUserRepo rur = new RegistredUserRepo(MysqlDataProvider.getInstance());
//        
        
//        pr.getList().forEach(el -> System.out.println(el.getName()));
//        gr.getList().forEach(el -> System.out.println(el.getName()));      
//        ur.getList().forEach(el -> System.out.println(el.getName()));
//        rur.getList().forEach(el -> System.out.println(el.getName()));
        

        
//        Game game = gr.getList().get(0);
        
        BaseSingleTable bst = new BaseSingleTable();
        bst.setBaseField("baseSinglTable");
        
        ChildSingleTable cst = new ChildSingleTable();
        cst.setBaseField("childSingleTable");
        cst.setChildField("childSingleTable2");
        
        
        
        BaseJoined bj = new BaseJoined();
        bj.setBaseField("baseJoined");
        
        ChildJoined cj = new ChildJoined();
        cj.setBaseField("childJoined");
        cj.setChildField("childJoined2");     
        
        
        
        BaseTablePerClass btpc = new BaseTablePerClass();
        btpc.setBaseField("baseTablePerClass");
        
        ChildTablePerClass ctpc = new ChildTablePerClass();
        ctpc.setBaseField("childTablePerClass");
        ctpc.setChildField("childTablePerClass2"); 
        
//        HsqlDataProvider.getInstance().getUserNames().forEach(i -> System.out.println(i));
//        HsqlDataProvider.getInstance().getTableNames().forEach(i -> System.out.println(i));
        
        //Session session = MysqlDataProvider.getInstance().getSession();
//        Session session = HsqlDataProvider.getInstance().getSession();
        Session session = MysqlDataProvider.getInstance().getSession();
        try {           
            session.beginTransaction();
            
//            session.save(bst);
//            session.save(cst);
//            session.save(bj);
//            session.save(cj);
//            session.save(btpc);
//            session.save(ctpc);
            
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        

        System.exit(0);
    }
}
