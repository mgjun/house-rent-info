package com.example.houserentinfo.repository;

import com.example.houserentinfo.entity.BaseEntity;
import org.jooq.Param;
import org.jooq.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class BaseJooqRepositoryImpl<E extends BaseEntity> implements BaseJooqRepository<E> {

    @Autowired
    private EntityManager em;

    @Override
    public List<E> nativeQuery(Query query, Class<E> type) {
        javax.persistence.Query result = em.createNativeQuery(query.getSQL(), type);
        AtomicInteger index = new AtomicInteger(0);
        Map<String, Param<?>> params = query.getParams();
        if (params != null && params.size() > 0) {
            params.values().forEach(param -> result.setParameter(index.incrementAndGet(), convertToDatabaseType(param)));
        }

        return result.getResultList();
    }


    @Override
    public void executeUpdate(Query query) {
        javax.persistence.Query result = em.createQuery(query.getSQL());
        AtomicInteger index = new AtomicInteger(0);
        Map<String, Param<?>> params = query.getParams();
        if (params != null && params.size() > 0) {
            params.values().forEach(param -> result.setParameter(index.incrementAndGet(), convertToDatabaseType(param)));
        }

        result.executeUpdate();
    }


    <T> Object convertToDatabaseType(Param<T> param) {
        return param.getBinding().converter().to(param.getValue());
    }
}
