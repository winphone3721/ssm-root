/*package com.wnslp.ssm.controller;

import com.wnslp.ssm.util.ApiResult;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@RestController
public class ShortenUrlController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ShortenUrlController.class);

    private static final String DEFAULT_REDIRECT = "http://m.chexian.com";
    private static final int DEFAULT_EXPIRES = 90;

    private final ShortUrlService shortUrlService;
    private final ShortUrlAccessRecordService shortUrlAccessRecordService;

    @Autowired
    public ShortenUrlController(ShortUrlServiceImpl shortUrlService,
                                ShortUrlAccessRecordService shortUrlAccessRecordService) {
        this.shortUrlService = shortUrlService;
        this.shortUrlAccessRecordService = shortUrlAccessRecordService;
    }


    public ApiResult<String> getLongUrl(@RequestParam("shorturl") String shortUrlCode) {
        if (StringUtils.isBlank(shortUrlCode)) {
            return fail(ApiErrorCode.MISSING_PARAMS.value(), "longurl 参数不能为空");
        }

        Optional<ShortUrl> shortUrl = shortUrlService.getShortUrl(shortUrlCode);
        if (shortUrl.isPresent()) {
            return ok(shortUrl.get().getLongUrl());
        } else {
            return fail(ApiErrorCode.NOT_FOUND.value(), "短地址[" + shortUrlCode + "]不存在或者已过期");
        }
    }


    public ApiResult<String> genShortUrl(@RequestBody ShortUrlParam shortUrlParam) {
        if (null == shortUrlParam) {
            return fail(ApiErrorCode.MISSING_PARAMS.value(), "ShortUrlParam 参数不能为空");
        }

        if (StringUtils.isBlank(shortUrlParam.getLongUrl())) {
            return fail(ApiErrorCode.MISSING_PARAMS.value(), "longUrl 参数不能为空");
        }

        ShortUrlDomain shortUrlDomain;

        if (null == shortUrlParam.getDomain()) {
            shortUrlDomain = ShortUrlDomain.CHE_XIAN;
        } else {
            Optional<ShortUrlDomain> optional = ShortUrlDomain.valueOf(shortUrlParam.getDomain());
            if (optional.isPresent()) {
                shortUrlDomain = optional.get();
            } else {
                return fail(ApiErrorCode.NOT_FOUND.value(), "不支持的短地址域名");
            }
        }

        if (null == shortUrlParam.getExpires() || shortUrlParam.getExpires() <= 0) {
            shortUrlParam.setExpires(DEFAULT_EXPIRES);
        } else if (shortUrlParam.getExpires() > 365) {
            return fail(ApiErrorCode.INVALID_FORMAT.value(), "过期时间最大 365 天");
        }

        String longURL = HtmlUtils.htmlUnescape(shortUrlParam.getLongUrl());
        Optional<String> optional = shortUrlService.getShortUrl(
                longURL,
                shortUrlDomain,
                shortUrlParam.getExpires());

        if (optional.isPresent()) {
            return ok(optional.get());
        } else {
            return fail(ApiErrorCode.INSERT_FAIL.value(), "短地址生成失败");
        }
    }

    @GetMapping("/refreshdata")
    public ApiResult<?> refreshShortURLData(
            @RequestParam(value = "shortUrlCode", required = false) String shortUrlCode) {
        shortUrlService.refreshShortURLData(shortUrlCode);
        return ok(null);
    }

    @GetMapping("/redirect/{shortUrlCode}")
    public String redirect302(@PathVariable("shortUrlCode") String shortUrlCode,
                              HttpServletRequest request, HttpServletResponse response) {
        // response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        // response.setHeader("Location", "url");

        try {
            Optional<ShortUrl> shortUrl = shortUrlService.getShortUrl(shortUrlCode);
            if (shortUrl.isPresent()) {
                saveAccessRecord(request, shortUrl.get());
                response.sendRedirect(shortUrl.get().getLongUrl());
            } else {
                LOGGER.info("短地址[{}]不存在或者已过期", shortUrlCode);
                response.sendRedirect(DEFAULT_REDIRECT);
            }
        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
            try {
                response.sendRedirect(DEFAULT_REDIRECT);
            } catch (Exception ignored) {
            }
        }

        return null;
    }

    private void saveAccessRecord(HttpServletRequest request, ShortUrl shortUrl) {
        try {
            String clientIP = RequestUtils.getClientIpAddress(request);
            String userAgent = request.getHeader(HttpHeaders.USER_AGENT);

            ShortUrlAccessRecord record = new ShortUrlAccessRecord();
            record.setRequestIp(clientIP);
            record.setUserAgent(userAgent);
            record.setShortUrlId(shortUrl.getId());
            shortUrlAccessRecordService.insert(record);
        } catch (Exception ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
    }
}
*/