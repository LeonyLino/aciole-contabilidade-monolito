package br.com.aciolecontabilidade.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;

import com.google.common.collect.Lists;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger.web.SecurityConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
public class SwaggerConfig {
	

	@Bean
	public Docket restApi() {
		return new Docket(DocumentationType.SWAGGER_2).enable(true).select()
				.apis(RequestHandlerSelectors.any()).build()
				.apiInfo(apiInfo())
				.securitySchemes(Lists.newArrayList(apiKey()))
		        .securityContexts(Arrays.asList(securityContext()));
	}

	@Bean
	public SecurityConfiguration security() {
		return SecurityConfigurationBuilder.builder().scopeSeparator(",").additionalQueryStringParams(null)
				.useBasicAuthenticationWithAccessCodeGrant(false).build();
	}
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Aciole Contabilidade")
								   .description("ACIOLE - API")
								   .version("1.0").build();
	}

	private ApiKey apiKey() {
		return new ApiKey("Bearer", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.any()).build();
	}

	private List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Arrays.asList(new SecurityReference("Bearer", authorizationScopes));
	}
}
