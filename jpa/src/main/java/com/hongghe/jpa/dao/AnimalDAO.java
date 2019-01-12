package com.hongghe.jpa.dao;

/**
 * @author: hongghe @date: 2019-01-12 10:41
 */

import com.hongghe.jpa.entity.Animal;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalDAO extends PagingAndSortingRepository<Animal, Long>, JpaSpecificationExecutor<Animal> {

    @Query(value = "select id from Animal t where t.id = :id")
    Long findByUserName(@Param("id") Long id);

    @Query("from Animal t where id = :id")
    List<Animal> queryFamilyList(@Param("id") Long id);

}