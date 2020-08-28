package com.wnslp.ssm.service;

import com.wnslp.ssm.domain.entity.InfParm;

public interface InfParmService {
    Boolean insert(InfParm infParm);

    Boolean updateById(InfParm infParm);

    boolean deleteById(int id);
}
