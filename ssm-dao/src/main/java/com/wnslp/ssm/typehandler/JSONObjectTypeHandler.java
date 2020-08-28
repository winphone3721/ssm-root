package com.wnslp.ssm.typehandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@MappedJdbcTypes({JdbcType.VARCHAR})
public class JSONObjectTypeHandler extends BaseJSONTypeHandler<JSONObject> {

    private static final Logger LOGGER = LoggerFactory.getLogger(JSONObjectTypeHandler.class);

    public JSONObjectTypeHandler(Class<JSONObject> type) {
        super(type);
    }

    @Override
    protected JSONObject parseJSONString(String jsonString) {
        JSONObject jsonObject;

        try {
            jsonObject = JSON.parseObject(jsonString);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }

        return jsonObject;
    }
}

