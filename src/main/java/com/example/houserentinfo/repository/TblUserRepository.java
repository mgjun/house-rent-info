package com.example.houserentinfo.repository;

import com.example.houserentinfo.entity.TblUser;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TblUserRepository extends PagingAndSortingRepository<TblUser,Long>,BaseJooqRepository<TblUser> {

    TblUser findByUserName(String username);
}
