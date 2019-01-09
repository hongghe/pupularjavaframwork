package com.hongghe.jpa.dao;

import com.hongghe.jpa.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: hongghe @date: 2019-01-09 16:14
 */
@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Long>, JpaSpecificationExecutor<User> {

    User findByUserName(String userName);

    @Query("from User t where id = :id")
    List<User> queryFamilyList(@Param("id") Long id, Pageable pageable);

}