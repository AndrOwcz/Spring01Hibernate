package pl.coderslab.app.author;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Author entity) {
        entityManager.persist(entity);
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author entity) {
        entityManager.merge(entity);
    }

    public void deleteById(Long id) {
        Author authorToDelete = findById(id);
        if (authorToDelete != null) {
            entityManager.remove(authorToDelete);
        }
    }

    public List<Author> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Author b");
        return query.getResultList();
    }
}
