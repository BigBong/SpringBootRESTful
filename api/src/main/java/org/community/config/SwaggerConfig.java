package org.community.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created by frodo on 2017/8/3.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.community.controller.api"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Community项目 Platform REST API",
                initContextInfo(),
                "1.0.0",
                "服务条款",
                new Contact("后台开发团队", "http://frodoking.github.io/", "awangyun8@gmail.com"),
                "The Apache License, Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>()
        );
    }

    private String initContextInfo() {
        return "REST API 设计在细节上有很多自己独特的需要注意的技巧，并且对开发人员在构架设计能力上比传统 API 有着更高的要求。" +
                "<br/>" +
                "本文通过翔实的叙述和一系列的范例，从整体结构，到局部细节，分析和解读了为了提高易用性和高效性，REST API 设计应该注意哪些问题以及如何解决这些问题。";
    }
}
