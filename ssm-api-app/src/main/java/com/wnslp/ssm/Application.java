package com.wnslp.ssm;

import org.springframework.boot.Banner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.retry.annotation.EnableRetry;

//import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchAutoConfiguration;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableRetry
//@EnableDiscoveryClient
@SpringBootApplication(
        scanBasePackages = {PkgConsts.BASE_PACKAGE}//,
        //exclude = {
               // ElasticsearchAutoConfiguration.class,
                //ElasticsearchDataAutoConfiguration.class,
               // RedisRepositoriesAutoConfiguration.class,
                //RedisReactiveAutoConfiguration.class
       // }
        )
//@Configuration
//@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Application.class)
                .bannerMode(Banner.Mode.OFF)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
