package cz.vsb.bed0152.jat.flightreservation.flightreservation.repository;

import cz.vsb.bed0152.jat.flightreservation.flightreservation.util.Extensions;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Delegate;
import lombok.experimental.ExtensionMethod;
import lombok.val;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Map;

@RequiredArgsConstructor
@ExtensionMethod({Extensions.class})
public abstract class AbstractRepository<T> {

    @PersistenceContext
    @Delegate
    @Getter(value = AccessLevel.PROTECTED)
    private EntityManager entityManager;

    private final Class<T> entityClass;

    public Collection<T> getAll() {
        return entityManager.findAll(entityClass);
    }

    public T find(int id) {
        return this.find(entityClass, id);
    }

    @Transactional
    public void delete(int id) {
        val entity = entityManager.find(entityClass, id);

        if (entity != null) {
            entityManager.remove(entity);
            entityManager.flush();
        }
    }

    public Collection<T> findBy(Map<String, Object> criteria) {
        return entityManager.findBy(entityClass, criteria);
    }
}
