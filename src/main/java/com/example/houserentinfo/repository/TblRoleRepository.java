package com.example.houserentinfo.repository;

import com.example.houserentinfo.entity.TblRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblRoleRepository extends PagingAndSortingRepository<TblRole,Long>,BaseJooqRepository<TblRole> {
}
