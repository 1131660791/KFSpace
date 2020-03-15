package com.boot.demo.config.swagger;


import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import java.util.Collections;

@Configuration
@EnableSwagger2
@ConditionalOnExpression("${setting.swagger.enable:true}")
public class SwaggerConfig {
    @Bean
    public Docket swaggerSpringMvcPlugin() {
        ApiInfo apiInfo = new ApiInfo(
                "个人项目-服务端",
                "",
                "1.0-SNAPSHOT",
                null,
                new Contact("黄忠旺", "", "1131660791@qq.com"),
                "成都信息技术有限公司",
                "www.baidu.com",
                Collections.emptyList());

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                // 这个配置是用来指定我们的接口层的位置
                .apis(RequestHandlerSelectors.basePackage("com.boot.demo"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo)
                .useDefaultResponseMessages(false);
    }
}