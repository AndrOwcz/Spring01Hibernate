package pl.coderslab.app.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class GenericDao<T> {

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<T> classType;

    public GenericDao(Class<T> classType) {
        this.classType = classType;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public T find(Long id) {
        return entityManager.find(classType, id);
    }

    public void delete(Long id) {
        T entity = find(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public List<T> findAll() {
        Query query = entityManager.createQuery("SELECT b FROM " + classType.getSimpleName() + " b");
        return query.getResultList();
    }
}