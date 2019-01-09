package com.hongghe.jpa.dao;

import com.hongghe.jpa.entity.Tuser;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author: hongghe @date: 2019-01-09 16:14
 */
@Repository
public interface TuserDao extends PagingAndSortingRepository<Tuser, Long>, JpaSpecificationExecutor<Tuser> {

    Tuser findByUserName(String userName);

    @Query("from Tuser t where id = :id")
    List<Tuser> queryFamilyList(@Param("id") Long id, Pageable pageable);

}