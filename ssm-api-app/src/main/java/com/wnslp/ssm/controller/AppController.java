package com.wnslp.ssm.controller;
/*
import ApiResult;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/app")
@RestController
public class AppController extends BaseController {

    private final AppService appService;

    @Autowired
    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping("/add")
    public ApiResult<Integer> addApp(@RequestBody AppParam app) {
        App app1 = BeanUtils.convert(app, App.class);
        return ok(appService.insert(app1));
    }

    @PostMapping("/update")
    public ApiResult<Integer> updateApp(@RequestBody AppParam app) {
        App app1 = BeanUtils.convert(app, App.class);
        return ok(appService.updateById(app1));
    }

    @PostMapping("/delete/{id}")
    public ApiResult<?> deleteApp(@PathVariable("id") int id) {
        boolean result = appService.deleteById(id);

        if (result) {
            return ok(null);
        } else {
            return fail(ApiErrorCode.UPDATE_FAIL.value(), "删除失败");
        }
    }

    @GetMapping("/one/{id}")
    public ApiResult<AppResult> findById(@PathVariable("id") int id) {
        AppResult appResult = Optional.ofNullable(appService.findById(id))
                .flatMap(app -> app.map(app1 -> BeanUtils.convert(app1, AppResult.class)))
                .orElse(null);

        return ok(appResult);
    }

    @GetMapping("/list")
    public ApiResult<PageBean<AppResult>> list(@RequestBody AppCriteria criteria) {
        if (criteria == null) {
            return fail(ApiErrorCode.MISSING_PARAMS.value(), "缺少参数");
        }

        PageBean<AppResult> pageBean = appService.findPaged(criteria)
                .map(page -> {
                    List<AppResult> list = BeanUtils.convert(page.getResult(), AppResult.class);
                    return PageBean.<AppResult>newBuilder()
                            .page(page.getPageNum())
                            .size(page.getPageSize())
                            .total(page.getTotal())
                            .pages(page.getPages())
                            .data(list)
                            .build();
                }).orElse(PageBean.<AppResult>newBuilder().empty());

        return ok(pageBean);
    }
}
*/