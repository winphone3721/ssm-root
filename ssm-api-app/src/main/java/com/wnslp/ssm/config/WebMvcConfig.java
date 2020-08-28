package com.wnslp.ssm.config;

import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("Duplicates")
final class WebMvcConfig {

    static final String[] RESOURCE_LOCATIONS = {
            "classpath:/static/",
            "classpath:/public/",
            "classpath:/resources/",
            "classpath:/META-INF/resources/"};

    private WebMvcConfig() {
    }

    static void configureContentNegotiation(final ContentNegotiationConfigurer configurer) {
        Map<String, MediaType> mediaTypes = new HashMap<>(4);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);
        mediaTypes.put("xml", MediaType.APPLICATION_XML);
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("plain", MediaType.TEXT_PLAIN);

        configurer
                .favorPathExtension(false)
                .favorParameter(true)
                .parameterName("format")
                .ignoreAcceptHeader(true)
                .useRegisteredExtensionsOnly(true)
                .mediaTypes(mediaTypes)
                .defaultContentType(MediaType.APPLICATION_JSON);
    }
}