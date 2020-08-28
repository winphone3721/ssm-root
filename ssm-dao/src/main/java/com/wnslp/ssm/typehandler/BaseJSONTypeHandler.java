package com.wnslp.ssm.typehandler;

import com.alibaba.fastjson.JSON;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class BaseJSONTypeHandler<E extends JSON> extends BaseTypeHandler<E> {

    public BaseJSONTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type argument cannot be null");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int parameterIndex, E parameter, JdbcType jdbcType) throws SQLException {
        if (parameter == null) {
            ps.setString(parameterIndex, null);
        } else {
            ps.setString(parameterIndex, parameter.toJSONString());
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String json = rs.getString(columnName);
            return parseJSONString(json);
        }
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        if (rs.wasNull()) {
            return null;
        } else {
            String json = rs.getString(columnIndex);
            return parseJSONString(json);
        }
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        if (cs.wasNull()) {
            return null;
        } else {
            String json = cs.getString(columnIndex);
            return parseJSONString(json);
        }
    }

    protected abstract E parseJSONString(String jsonString);
}
