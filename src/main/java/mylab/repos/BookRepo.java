package mylab.repos;

import mylab.dataproviders.DataProvider;
import mylab.entities.Book;
import org.hibernate.Session;



public class BookRepo {   
    private DataProvider _dp;
    
    public BookRepo(DataProvider dp) {
        this._dp = dp;
    }
    
    public Book getById(long id) {
        Session session = _dp.getSession();
        
        Book book = session.get(Book.class, id);
        
        session.close();
        
        return book;
    }
}
