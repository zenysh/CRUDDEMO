
package com.project.Crud.demo.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicates;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket docket() {
	    return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
	            .apis(RequestHandlerSelectors.any()) 
	            .paths(PathSelectors.any()) 
	            .build();
	           // .pathMapping("/rest/*"); 
	         //   .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot"))).build();
	  }

	 private ApiInfo apiInfo() {
		    return new ApiInfoBuilder().title("Employee Profile API")
		            .description("This API can be used to get profile level actions and information for an Employee")
		            .version("V1.0").build();
		  }
}
