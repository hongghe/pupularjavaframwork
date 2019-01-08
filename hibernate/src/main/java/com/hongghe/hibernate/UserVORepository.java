package com.hongghe.hibernate;

import com.hongghe.hibernate.vo.UserVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * @author: hongghe @date: 2019-01-08 10:04
 */
public interface UserVORepository extends CrudRepository<UserVO, Long> {

    @Query("select u from UserVO u where u.username=:username")
    public UserVO findUserByName(@Param("username") String username);

    public UserVO findUserByUsername(String username);

}