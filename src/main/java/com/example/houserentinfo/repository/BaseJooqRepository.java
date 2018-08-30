package com.example.houserentinfo.repository;

import com.example.houserentinfo.entity.BaseEntity;
import org.jooq.Query;

import java.util.List;

public interface BaseJooqRepository<E extends BaseEntity> {

    List<E> nativeQuery(org.jooq.Query query, Class<E> type);

    void executeUpdate(Query query);
}
