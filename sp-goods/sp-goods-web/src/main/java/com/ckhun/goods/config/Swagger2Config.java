package com.ckhun.goods.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author : Kunhong Chan
 * @date : Created in 10:12 2021/1/31
 * @description :
 * @since : 1.0.0
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private static final String SWAGGER_TITLE = "商品模块接口文档";

    private static final String API_VERSION = "1.0.0";

    @Bean
    public Docket createRestApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ckhun.goods.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 添加摘要信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(SWAGGER_TITLE)
                .version(API_VERSION)
                .build();
    }
}
