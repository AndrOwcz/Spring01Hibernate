package pl.coderslab.app.book;

import org.springframework.stereotype.Repository;
import pl.coderslab.app.common.GenericDao;

@Repository
public class BookDaoGeneric extends GenericDao<Book> {

    public BookDaoGeneric() {
        super(Book.class);
    }
}