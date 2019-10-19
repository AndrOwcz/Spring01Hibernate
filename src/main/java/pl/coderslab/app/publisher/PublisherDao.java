package pl.coderslab.app.publisher;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class PublisherDao {

    @PersistenceContext
    EntityManager entityManager;

    public void save(Publisher entity) {
        entityManager.persist(entity);
    }

    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    public void deleteById(Long id) {
        Publisher publisherToDelete = findById(id);
        if (publisherToDelete != null) {
            entityManager.remove(publisherToDelete);
        }
    }

    public List<Publisher> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM Publisher b");
        return query.getResultList();
    }
}
