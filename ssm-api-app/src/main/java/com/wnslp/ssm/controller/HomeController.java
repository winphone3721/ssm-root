package com.wnslp.ssm.controller;

import com.wnslp.ssm.common.result.ApiResult;
import com.wnslp.ssm.domain.entity.InfParm;
import com.wnslp.ssm.service.InfParmService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private static final String DEFAULT_REDIRECT = "http://m.chexian.com";
    private static final int DEFAULT_EXPIRES = 90;

    private final InfParmService infParmService;

    @Autowired
    public HomeController(InfParmService infParmService) {
        this.infParmService = infParmService;
    }

    @GetMapping("/index")
    public ApiResult<?> home() {
        InfParm infParm = new InfParm();
        infParm.setParmName("测试");
        infParm.setParmValue("abc");

        return ok( infParmService.insert(infParm));
    }
    @GetMapping("/ok")
    public ApiResult<?>ok(){
        return ok(true);
    }
    @GetMapping("/error")
    public ApiResult<?>error(){
        return fail(1000,"this is error message");
    }
}

