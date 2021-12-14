package cz.vsb.bed0152.jat.flightreservation.flightreservation.util;

import lombok.experimental.UtilityClass;
import lombok.val;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@UtilityClass
public class Extensions {

    private <T> CriteriaQuery<T> createQueryFrom(EntityManager entityManager, Class<T> entity, Map<String, Object> criteria) {
        val cb = entityManager.getCriteriaBuilder();

        val query = cb.createQuery(entity);
        val from = query.from(entity);

        val predicates = criteria.entrySet().stream()
                .map(e -> cb.equal(from.get(e.getKey()), e.getValue()))
                .toArray(javax.persistence.criteria.Predicate[]::new);

        query.where(predicates);

        return query;
    }

    public <T> T findOneBy(EntityManager entityManager, Class<T> entity, Map<String, Object> criteria) {
        return entityManager
                .createQuery(createQueryFrom(entityManager, entity, criteria))
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    public <T> List<T> findBy(EntityManager entityManager, Class<T> entity, Map<String, Object> criteria) {
        return entityManager
                .createQuery(createQueryFrom(entityManager, entity, criteria))
                .getResultList();
    }

    public <T> List<T> findAll(EntityManager entityManager, Class<T> entity) {
        return findBy(entityManager, entity, Collections.emptyMap());
    }
}
