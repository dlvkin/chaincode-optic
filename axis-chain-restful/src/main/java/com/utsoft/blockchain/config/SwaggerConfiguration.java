package com.utsoft.blockchain.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author hunterfox
 * @date 2017年7月18日
 */
@Configuration
@EnableSwagger2
@Profile({"test"}) 
public class SwaggerConfiguration {

	 @Bean
	  public Docket createRestApi() {
	        return new Docket(DocumentationType.SWAGGER_2)
	                .apiInfo(apiInfo())
	                .select()
	                .apis(RequestHandlerSelectors.basePackage("com.utsoft.blockchain.api.controller"))
	                .paths(PathSelectors.any())
	                .build();
	    }

	   private ApiInfo apiInfo() {
	        return new ApiInfoBuilder()
	                .title("Spring Boot user Swagger2 for RESTful APIs")
	                .description("desp")
	                .termsOfServiceUrl("flyskyhunter@gmail.com")
	                .version("1.0")
	                .build();
	    }
}
