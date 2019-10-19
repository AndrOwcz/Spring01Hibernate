package pl.coderslab.app.book;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Transactional
public class BookCustomRepositoryImpl implements BookCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void resetRating(BigDecimal rating) {
        Query q = entityManager.createQuery("update Book b set b.rating = :newRating");
        q.setParameter("newRating", rating).executeUpdate();
    }
}
