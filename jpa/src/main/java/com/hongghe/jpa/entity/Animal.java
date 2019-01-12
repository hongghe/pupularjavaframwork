package com.hongghe.jpa.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author: hongghe @date: 2019-01-12 10:40
 */
@Data
@Entity
@Table(name = "t_user")
public class Animal implements java.io.Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "nickname")
    private String nickName;

}
