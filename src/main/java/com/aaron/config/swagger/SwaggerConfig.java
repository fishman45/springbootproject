package com.aaron.config.swagger;

import com.aaron.entity.common.Swagger;
import com.google.common.base.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.not;
import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author: lfl
 * @description: 打开swagger2的url:http://localhost:8080/swagger-ui.html
 * @date: Create in 2019/5/24 下午 02:40
 */
@Configuration
@EnableSwagger2
@EnableConfigurationProperties(Swagger.class)
public class SwaggerConfig {

    @Autowired
    private Swagger swagger;

    /***
     * 配置swagger
     * 开发和测试环境下可以开启swagger辅助进行调试,而生产环境下可以关闭或者进行相应的权限控制，防止接口信息泄露
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swagger.isEnable())
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aaron.controller"))
                .paths(PathSelectors.any())
                .paths(doFilteringRules())
                .build();
    }

    /***
     * 接口文档的描述信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("spring boot swagger2 用例")
                .description("描述")
                .licenseUrl("https://mit-license.org/")
                .version("1.0")
                .build();
    }

    /**
     * 可以使用正则定义url过滤规则
     */
    private Predicate<String> doFilteringRules() {
        return not(
                regex("/ignore/*")
        );
    }
}
