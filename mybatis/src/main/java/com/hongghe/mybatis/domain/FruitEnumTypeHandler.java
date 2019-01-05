package com.hongghe.mybatis.domain;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: hongghe @date: 2019-01-05 10:23
 */
public class FruitEnumTypeHandler implements TypeHandler<Integer> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public Integer getResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public Integer getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
