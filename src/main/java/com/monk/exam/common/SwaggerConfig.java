package com.monk.exam.common;

import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author monk
 * @description 自定义swagger3文档信息
 * @date 2022-04-22 13:34
 */
@Configuration
@ConditionalOnProperty(value = "springfox.documentation.enabled", havingValue = "true", matchIfMissing = true)
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                // 过滤条件，扫描指定路径下的文件
//                .apis(RequestHandlerSelectors.basePackage("com.monk.exam.controller"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 指定路径处理，PathSelectors.any()代表不过滤任何路径
                //.paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger3接口文档")
                .description("Spring Boot 集成 Swagger3 测试接口文档")
                .version("v1.0")
                .termsOfServiceUrl("https://gitee.com/Monk_ie")
                .contact(new Contact("monk", "https://gitee.com/Monk_ie", "Monk@outlook.ie"))
                .license("Apache 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .build();
    }
}
