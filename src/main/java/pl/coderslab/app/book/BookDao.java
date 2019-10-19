package pl.coderslab.app.book;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Repository
@Transactional
public class BookDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Book entity) {
        entityManager.persist(entity);
    }

    public Book findById(Long id) {
        return entityManager.find(Book.class, id);
    }

    public void update(Book entity) {
        entityManager.merge(entity);
    }

    public void deleteById(Long id) {
        Book bookToDelete = findById(id);
        if (bookToDelete != null) {
            entityManager.remove(bookToDelete);
        }
    }

    public Book findWithAuthors(Long id) {
        Book book = entityManager.find(Book.class, id);
        Hibernate.initialize(book.getAuthors());
        return book;
    }

    public List<Book> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }

    public List<Book> findAllWithPropositions() {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.proposition = true");
        return query.getResultList();
    }

    public List<Book> getRatingList(BigDecimal minRating) {
        Query query = entityManager.createQuery("SELECT b FROM Book b WHERE b.rating > :minRatingPar");
        query.setParameter("minRatingPar", minRating);
        return query.getResultList();
    }
}
