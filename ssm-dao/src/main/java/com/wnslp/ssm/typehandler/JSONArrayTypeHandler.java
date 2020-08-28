package com.wnslp.ssm.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MappedJdbcTypes({JdbcType.VARCHAR})
public class JSONArrayTypeHandler extends BaseJSONTypeHandler<JSONArray> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONArrayTypeHandler.class);

    public JSONArrayTypeHandler(Class<JSONArray> type) {
        super(type);
    }

    @Override
    protected JSONArray parseJSONString(String jsonString) {
        JSONArray jsonArray;

        try {
            jsonArray = JSON.parseArray(jsonString);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

        return jsonArray;
    }
}
