package com.wnslp.ssm.service.impl;

import com.wnslp.ssm.dao.mapper.InfParmMapper;
import com.wnslp.ssm.domain.entity.InfParm;
import com.wnslp.ssm.service.InfParmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InfParmServiceImpl  implements InfParmService {

    private final InfParmMapper infParmMapper;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public InfParmServiceImpl(InfParmMapper infParmMapper) {
        this.infParmMapper = infParmMapper;
    }
    public Boolean insert(InfParm infParm) {
        int result = infParmMapper.insert(infParm);
        if (result > 0)
            return true;
        return false;
    }

    public Boolean updateById(InfParm infParm) {
        if (null == infParm) {
            return false;
        }
        if(infParm.getId()<=0){
            return false;
        }
        int result = infParmMapper.updateById(infParm);
        if (result == 1)
            return true;
        return false;
    }

    public boolean deleteById(int id) {
        return false;
    }
}
